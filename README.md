# Spring Boot 4 Demo Project

This is a demo project showcasing new features in **Spring Boot 4** and **Java 25**.

## Features

### Spring Boot 4
1. **API Versioning**  
   Flexible API versioning supporting formats like `/api/v1/product`, `/api/v2.0/product` and `X-API-Version: v1, v2, v1.0, v2.0`.
   API versioning can be enabled in Header-based, Path-based, or Query parameter-based modes (see `WebConfiguration`).
   API versioning can also able to enable from application.yml file

2. **Enhanced HTTP Service Clients**  
   Modern HTTP clients for easier and more robust REST integrations.
   It enables to define an HTTP service through a Java interface with @HttpExchange-annotated methods. (see `ProductRestClientService`)

3. **Null Safety with JSpecify**  
   Improved null-safety using [JSpecify](https://jspecify.dev/) annotations.

4. **OpenTelemetry Integration**  
   Distributed tracing and observability with [OpenTelemetry](https://opentelemetry.io/).
   View traces in Grafana:
    - Open http://localhost:3000
    - Go to Drilldown
    - View Logs, Metrics, Traces

5. **Spring Boot Docker Compose**  
   Native support for running and managing services with Docker Compose.

### Java 25
- **Virtual Threads**  
  Utilizes Java 25's virtual threads for lightweight, scalable concurrency.
  To observe the performance difference, you can execute 200 GET requests to both endpoints and generate an Apache Bench (ab) benchmark report. Example commands:

    1. `ab -n 200 -c 200 -m GET "http://localhost:8080/threads/v1/traditional"`
    2. `ab -n 200 -c 200 -m GET "http://localhost:8080/threads/v1/virtual"`
  
## Getting Started

1. **Build the project:**
   ```sh
   ./mvnw clean package