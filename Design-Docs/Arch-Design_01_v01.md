# General information

 - Use gradle for building, testing, etc


 # Architectural Design


 ## Frontend (UI) Server

UI implemented in ReactJS

- Single page
- Two sections of the page:
  - Top-section
    - Title of "Product List"
    - Table with 2 columns
      - Column 1 labeled "Id"
      - Column 2 labeled "Name"
  - Bottom-section 
    - Title of "Add new product"
    - Text input labeled "Name", with button to right of it labeled "Add"
  - Served up by nginx running in a docker container
    - Use port 3000 by default


 ## Backend Server

- Implemented in Java
- Using Springboot
- REST API Server which provides the following REST endpoints:
  - GET /product
   - Returns all rows from DB table "product"
   - Each row has fields:
     - `id`
     - `name`
  - POST /product
    - Body is JSON with fields:
      - `name`
- Stores it's data into the Database (described below)
  - Use Hibernate for DB operations


 ## Database

 - MySQL
   - Latest version
   - Running in a Docker container
- One table called "product", with following columns
  - `id` - primary key
  - `name` VARCHAR(250)

## Deployment

NOTE: This is for a local development environment. The actual AWS environment would be different deployment.

## Docker containers

The following will be running in Docker containers:

- nginx to serve up the fronted UI ReactJS
- MySQL database

A single docker-compoase file will be created to run both

## IntelliJ debugger

The following will be running in IntelliJ debuger:

- Backend Server

# Not Included

- Security
  - UI - User login
  - REST - Authentication
  - DB login creds
- Logging
- Scalability/Performance
  - REST call is returning all rows from DB table. Should add Paging.
  - Load balancers
  - Caching
- Fault tolerance
  - Fail overs for backend server
  - DB read-replica
