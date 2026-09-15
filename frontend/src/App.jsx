import { useEffect, useState } from 'react';

const API_PATH = '/product';

export default function App() {
  const [products, setProducts] = useState([]);
  const [name, setName] = useState('');
  const [error, setError] = useState('');
  const [isLoading, setIsLoading] = useState(true);
  const [isSubmitting, setIsSubmitting] = useState(false);

  useEffect(() => {
    async function loadProducts() {
      try {
        const response = await fetch(API_PATH);
        if (!response.ok) throw new Error('Unable to load products.');
        setProducts(await response.json());
      } catch (loadError) {
        setError(loadError.message);
      } finally {
        setIsLoading(false);
      }
    }

    loadProducts();
  }, []);

  async function addProduct(event) {
    event.preventDefault();
    setError('');
    setIsSubmitting(true);

    try {
      const response = await fetch(API_PATH, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name }),
      });
      if (!response.ok) throw new Error('Unable to add the product.');
      const product = await response.json();
      setProducts((currentProducts) => [...currentProducts, product]);
      setName('');
    } catch (submitError) {
      setError(submitError.message);
    } finally {
      setIsSubmitting(false);
    }
  }

  return (
    <main>
      <section aria-labelledby="product-list-title">
        <h1 id="product-list-title">Product List</h1>
        {isLoading ? <p>Loading products…</p> : (
          <table>
            <thead><tr><th>Id</th><th>Name</th></tr></thead>
            <tbody>
              {products.map((product) => <tr key={product.id}><td>{product.id}</td><td>{product.name}</td></tr>)}
            </tbody>
          </table>
        )}
      </section>

      <section aria-labelledby="add-product-title">
        <h2 id="add-product-title">Add new product</h2>
        <form onSubmit={addProduct}>
          <label htmlFor="name">Name</label>
          <input id="name" name="name" value={name} maxLength="250" onChange={(event) => setName(event.target.value)} />
          <button type="submit" disabled={isSubmitting}>{isSubmitting ? 'Adding…' : 'Add'}</button>
        </form>
        {error && <p role="alert">{error}</p>}
      </section>
    </main>
  );
}

