# General information

## Backend Server

- Implemented in Java using Spring Boot.
- REST API server providing the following endpoint:
  - `GET /order`
    - Returns all rows from the `orders` database table in ascending `order_id` order.
    - Each returned order has fields:
      - `order_id`
      - `order_date` — ISO 8601 date in `YYYY-MM-DD` format
      - `order_value`
      - `order_details` — an array of line items ordered by ascending `product_id`. Each line item has:
        - `order_id`
        - `product`
          - `id` — foreign key to the `product` table
          - `name` — from the `product` table
        - `item_price`
        - `item_quantity`
- Stores its data in the database described below.
- Uses Hibernate for database operations.

## Database

- Database schema changes are managed with Liquibase XML changelogs.
- Add a table named `orders`, with the following columns:
  - `order_id` — database-generated primary key
  - `order_date` — `DATE`
  - `order_value` — stored supplied value, represented as `DECIMAL(..., 2)`
- Add a table named `order_details`, with the following columns:
  - `order_id` — required foreign key to `orders`
  - `product_id` — required foreign key to `product`
  - `item_price` — required `DECIMAL(..., 2)`
  - `item_quantity` — required positive whole-number `INT`
- `order_details` uses a composite primary key of (`order_id`, `product_id`), allowing one line item per product in an order.
- For now, `order_value` is stored as supplied. A future feature may calculate it as the sum of each line item's `item_price × item_quantity`.
- Orders for local development are populated with manual SQL. A create-order API will be added in a future feature.

# Not Included

- User interface changes
- Security
  - UI user login
  - REST authentication
  - Database login credentials
- Logging
- Scalability/performance
  - The REST call returns all rows from the database table; paging should be added.
  - Load balancers
  - Caching
- Fault tolerance
  - Backend-server failover
  - Database read replica
