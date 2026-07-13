# Microservice Consul Demo

Demo Maven multi-module cho Spring Boot microservices với API Gateway, Consul discovery/service mesh và PostgreSQL.

## Modules

- `api-gateway`: Spring Cloud Gateway, expose `/api/products/**` và `/api/orders/**`.
- `product-service`: Product CRUD với PostgreSQL riêng, Flyway migration và seed data.
- `order-service`: Order CRUD với PostgreSQL riêng, gọi product qua upstream mesh trước khi tạo order.
- `common`: DTO dùng chung giữa các service.

## Run Tests

```bash
mvn test
```

## Build

```bash
mvn package
```

## Run With Docker Compose

```bash
docker compose up --build
```

If your Docker CLI does not provide the `docker compose` subcommand, use the standalone binary:

```bash
docker-compose up --build
```

Sau khi stack chạy:

- API Gateway: <http://localhost:8080>
- Consul UI: <http://localhost:8500>
- Product PostgreSQL: `localhost:5433`
- Order PostgreSQL: `localhost:5434`

## Smoke Tests

```bash
curl http://localhost:8080/api/products
```

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d "{\"name\":\"Laptop Stand\",\"price\":45.50}"
```

```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d "{\"productId\":1,\"quantity\":2}"
```

```bash
curl http://localhost:8080/api/orders
```

## Consul Mesh Notes

Consul loads service definitions from `consul/services/*.hcl`. The gateway sidecar exposes upstreams for `product-service` and `order-service`, while the order sidecar exposes an upstream for `product-service`.

The Spring apps do not self-register; registration is intentionally defined in Consul HCL so the service mesh wiring is easy to inspect. Intentions are created by the `consul-intentions` compose service.

The compose file builds `consul-envoy/Dockerfile`, which combines the Consul CLI with an Envoy binary, then starts each proxy with `consul connect envoy -sidecar-for <service>`.
