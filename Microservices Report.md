
# 🚀 Microservices

> Tài liệu tổng hợp các thành phần chính trong kiến trúc Microservices.

## Microservice

**Microservice** là kiểu kiến trúc chia một ứng dụng lớn thành nhiều service nhỏ, mỗi service phụ trách một nghiệp vụ riêng và có thể deploy độc lập, giao tiếp với nhau thông qua API hoặc Message Queue.

### Ưu điểm

- Dễ mở rộng từng service.
- Dễ bảo trì và phát triển.
- Deploy độc lập, một service bị lỗi không nhất thiết làm toàn bộ hệ thống ngừng hoạt động.
- Các team có thể làm việc song song.
- Có thể dùng nhiều công nghệ khác nhau.

### Nhược điểm

- Hệ thống phức tạp hơn.
- Cần quản lý giao tiếp giữa các service.
- Khó theo dõi lỗi.
- Triển khai và vận hành đòi hỏi Docker, Kubernetes, API Gateway, Service Discovery,...

---

# Microservice gồm những phần nào và các tools tương ứng

| Thành phần | Technical name | Tác dụng | Tools |
|---|---|---|---|
| API Gateway | **API Gateway** | Điểm vào duy nhất của hệ thống. Routing, JWT/OAuth2, Rate Limiting, Load Balancing, Logging, CORS. | Spring Cloud Gateway<br>Kong Gateway<br>Apigee<br>MuleSoft<br>Gravitee |
| Discovery Service | **Service Discovery** | Quản lý địa chỉ (IP/Port) của các service. Service tự Register và Discover. | Netflix Eureka<br>Consul<br>Kubernetes DNS |
| Config Server | **Centralized Configuration Management** | Quản lý tập trung application.yml, DB, JWT, Redis... | Spring Cloud Config<br>Consul KV<br>Kubernetes ConfigMap |
| Business Services | **Microservices / Domain Services** | Chứa logic nghiệp vụ như User, Product, Order, Payment... | Spring Boot<br>ASP.NET Core<br>Node.js |
| Database | **Database per Service Pattern** | Mỗi service có database riêng để giảm phụ thuộc và tăng khả năng mở rộng. | PostgreSQL<br>MySQL<br>MongoDB |
| Message Broker | **Message Broker / Event Broker** | Giao tiếp bất đồng bộ thông qua Event hoặc Message. | RabbitMQ<br>Apache Kafka<br>ActiveMQ |
| Cache | **Distributed Cache / In-memory Cache** | Giảm tải Database và tăng tốc phản hồi. | Redis<br>Memcached |
| Load Balancer | **Load Balancer** | Phân phối request đến nhiều instance. | NGINX<br>Envoy Proxy<br>Traefik |
| Circuit Breaker | **Circuit Breaker Pattern** | Ngăn lỗi lan truyền khi service khác lỗi. | Resilience4j<br>Failsafe<br>Istio |
| Retry | **Retry Pattern** | Tự động gọi lại khi request thất bại tạm thời. | Resilience4j<br>Spring Retry |
| Bulkhead | **Bulkhead Pattern** | Cô lập tài nguyên giữa các service. | Resilience4j<br>Istio<br>Envoy Proxy |
| Rate Limiter | **Rate Limiting** | Giới hạn số lượng request chống spam/DDoS. | Resilience4j<br>Spring Cloud Gateway |
| Distributed Lock | **Distributed Lock** | Đảm bảo chỉ một service xử lý tài nguyên tại một thời điểm. | Redis<br>HashiCorp Consul |
| Saga | **Saga Pattern** | Quản lý transaction phân tán bằng local transaction và compensation. | Axon Framework<br>Temporal<br>Apache Kafka |
| Event Bus | **Event-Driven Architecture (EDA)** | Các service giao tiếp thông qua Event. | Apache Kafka<br>RabbitMQ |
| Authentication | **Authentication Service** | Xác minh danh tính người dùng (JWT, OAuth2, OpenID Connect). | Keycloak<br>Auth0<br>Spring Security OAuth2 |
| Authorization | **Authorization** | Kiểm tra quyền truy cập (RBAC/Permission). | Spring Security<br>Keycloak |
| Monitoring | **Application Monitoring** | Theo dõi CPU, RAM, Request, Response Time, Error Rate. | Prometheus |
| Logging | **Centralized Logging** | Thu thập log tập trung. | Fluent Bit<br>Loki |
| Tracing | **Distributed Tracing** | Theo dõi request qua nhiều service. | OpenTelemetry<br>Jaeger<br>Zipkin |
| Metrics | **Metrics Collection** | Thu thập request/sec, latency, JVM metrics... | Micrometer<br>OpenTelemetry |
| Health Check | **Health Check** | Kiểm tra service còn hoạt động hay không. | Spring Boot Actuator |
| Service Registry | **Service Registry** | Nơi lưu thông tin các service đã đăng ký. | Eureka<br>Consul |
| Containerization | **Containerization** | Đóng gói service thành container. | Docker<br>Podman<br>LXC |
| Orchestration | **Container Orchestration** | Deploy, Scale, Rolling Update, Self-healing. | Kubernetes |
| CI/CD | **Continuous Integration / Continuous Deployment** | Tự động build, test và deploy. | Jenkins<br>GitHub Actions<br>GitLab CI<br>Azure DevOps |
| Infrastructure as Code | **Infrastructure as Code (IaC)** | Quản lý hạ tầng bằng code. | Terraform<br>OpenTofu |
| Secret Management | **Secret Management** | Quản lý Password, API Key, JWT Secret... | HashiCorp Vault<br>Kubernetes Secrets |
| Observability | **Observability** | Kết hợp Metrics + Logging + Tracing để quan sát toàn bộ hệ thống. | OpenTelemetry<br>Prometheus<br>Grafana<br>Loki<br>Jaeger |
