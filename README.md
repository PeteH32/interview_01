# Product List

Local development implementation of the architecture in `Design-Docs/Arch-Design_01_v02.md`.

## Prerequisites

- Java 21
- Gradle 8.14 or newer
- Docker Compose

## Run locally

1. Start MySQL and the nginx-served UI:

   ```sh
   docker compose up --build
   ```

2. In a second terminal, run the backend from IntelliJ or with Gradle:

   ```sh
   gradle bootRun
   ```

3. Open http://localhost:3000.

nginx sends `/product` requests to the backend at `host.docker.internal:8080`. The backend's default database settings match the MySQL container; override `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` when needed.

## Verify

```sh
gradle test
```

