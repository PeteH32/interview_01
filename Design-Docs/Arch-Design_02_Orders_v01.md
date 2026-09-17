# General information

## Backend Server

- Implemented in Java using Spring Boot.
- REST API server providing the following endpoints:
  - `GET /order`
    - Returns all rows from the `order` database table.
    - Each returned order has fields:
      - `order_id`
      - `order_date`
      - `order_value`
      - `order_details`
        - `order_id`
        - `product.id` - FK to table `product`
        - `product.name` - from table `product`
        - `item_price`
        - `item_quantity`
    - Products are returned in ascending `id` order.
- Stores data in the database described below.
- Uses Hibernate for database operations.

## Database

- Database schema changes are managed with Liquibase XML changelogs.
- Add new table named `order`, with the following columns:
  - order_id PK
  - order_date
  - order_value
- Add new table named `order_details`, with the following columns:
  - order_id FK
  - product_id FK
  - item_price
  - item_quantity

- The maximum length of a submitted product name is 250 characters, matching the database column.

# Not Included

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
