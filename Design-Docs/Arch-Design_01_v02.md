# General information

- Use Gradle for building, testing, etc.

# Architectural Design

## Frontend (UI) Server

UI implemented in ReactJS.

- Single page
- Two sections of the page:
  - Top section
    - Title: "Product List"
    - Table with two columns:
      - Column 1 labeled "Id"
      - Column 2 labeled "Name"
  - Bottom section
    - Title: "Add new product"
    - Text input labeled "Name", with an "Add" button to its right
- Served by nginx running in a Docker container.
- nginx is exposed on port 3000 by default.
- nginx reverse-proxies API requests to the backend server.

## Backend Server

- Implemented in Java using Spring Boot.
- REST API server providing the following endpoints:
  - `GET /product`
    - Returns all rows from the `product` database table.
    - Each returned product has fields:
      - `id`
      - `name`
    - Products are returned in ascending `id` order.
  - `POST /product`
    - Accepts a JSON body with the field:
      - `name`
    - Returns `201 Created` and the created product, including its generated `id`.
- Stores data in the database described below.
- Uses Hibernate for database operations.

## Database

- MySQL 8.4, running in a Docker container.
- Database schema changes are managed with Liquibase XML changelogs.
- One table named `product`, with the following columns:
  - `id` — primary key
  - `name` — `VARCHAR(250)`
- The maximum length of a submitted product name is 250 characters, matching the database column.

## Deployment

NOTE: This is for a local development environment. The actual AWS environment would use a different deployment approach.

## Docker containers

The following run in Docker containers:

- nginx, which serves the frontend React UI and reverse-proxies requests to the backend API
- MySQL 8.4 database

A single Docker Compose file runs both containers.

## IntelliJ debugger

The following runs in the IntelliJ debugger:

- Backend Server

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
