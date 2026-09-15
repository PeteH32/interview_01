# Product List

Local development implementation of the architecture in `Design-Docs/Arch-Design_01_v02.md`.

## Prerequisites

- Java 21
- Gradle 8.14 or newer
- Docker Compose


## Architecture Overview

Simplified architecture:

![Design-Docs/Arch-Diagram_01.jpg](./Design-Docs/Arch-Diagram_01.jpg)

For full architecture, see this design document
- [./Design-Docs/Arch-Design_01_v02.md](./Design-Docs/Arch-Design_01_v02.md)

## Run locally

1. Start MySQL and the nginx-served UI:

   ```sh
   docker compose up --build
   ```

2. Backend Server - In a second terminal, run the backend from IntelliJ or with Gradle:

   ```sh
   ./gradlew bootRun
   ```
NOTE: You can also run the Backend Server in IntelliJ debugger. If so, skip above step.

3. Open http://localhost:3000.

nginx sends `/product` requests to the backend at `host.docker.internal:8080`. The backend's default database settings match the MySQL container; override `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` when needed.

## Verify

```sh
./gradlew test
```

