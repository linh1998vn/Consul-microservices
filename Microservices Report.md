# Microservices

## Microservice

**Microservice** là kiểu kiến trúc chia một ứng dụng lớn thành nhiều service nhỏ, mỗi service phụ trách một nghiệp vụ riêng và có thể deploy độc lập, giao tiếp với nhau thông qua API hoặc message queue.

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
- Triển khai và vận hành đòi hỏi các công cụ như Docker, Kubernetes, API Gateway, Service Discovery,…

## Microservice gồm những phần nào và các tools tương ứng

| Thành phần | Technical name | Tác dụng | Tools |
|---|---|---|---|
| API Gateway | **API Gateway** | Điểm vào duy nhất của hệ thống. Chịu trách nhiệm routing, xác thực JWT/OAuth2, rate limiting, load balancing, logging, CORS. | Spring Cloud Gateway<br>Kong Gateway<br>Apigee<br>Mulesoft<br>Gravitee |
| Discovery Service | **Service Discovery** | Quản lý địa chỉ (IP/Port) của các service. Các service tự đăng ký (register) và tìm nhau (discover) mà không cần hard-code địa chỉ. | Netflix Eureka<br>Consul<br>Kubernetes DNS |
| Config Server | **Centralized Configuration Management** | Quản lý tập trung file cấu hình (`application.yml`, DB, JWT, Redis...). Chỉ cần sửa một nơi thay vì từng service. | Spring Cloud Config<br>Consul KV<br>Kubernetes ConfigMap |
| Business Services | **Microservices / Domain Services** | Chứa logic nghiệp vụ như User Service, Product Service, Order Service, Payment Service... | Spring Boot<br>ASP.NET Core<br>Node.js |
| Database | **Database per Service Pattern** | Mỗi service có database riêng để giảm phụ thuộc và tăng khả năng mở rộng. | PostgreSQL<br>MySQL<br>MongoDB |
| Message Broker | **Message Broker / Event Broker** | Giao tiếp bất đồng bộ (Asynchronous Communication) thông qua Event hoặc Message. | RabbitMQ<br>Apache Kafka<br>ActiveMQ |
| Cache | **Distributed Cache / In-memory Cache** | Lưu dữ liệu truy cập thường xuyên để giảm tải database và tăng tốc phản hồi. | Redis<br>Memcached |
| Load Balancer | **Load Balancer** | Phân phối request đến nhiều instance của cùng một service nhằm tăng hiệu năng và khả năng chịu tải. | NGINX<br>Envoy Proxy<br>Traefik |
| Circuit Breaker | **Circuit Breaker Pattern** | Ngăn lỗi lan truyền khi một service bị lỗi hoặc phản hồi chậm. | Resilience4j<br>Failsafe<br>Istio |
| Retry | **Retry Pattern** | Tự động gọi lại khi request thất bại do lỗi tạm thời. | Resilience4j<br>Spring Retry |
| Bulkhead | **Bulkhead Pattern** | Cô lập tài nguyên giữa các service để lỗi của một phần không ảnh hưởng phần còn lại. | Resilience4j<br>Istio<br>Envoy Proxy |
| Rate Limiter | **Rate Limiting** | Giới hạn số lượng request từ client để chống spam hoặc DDoS. | Resilience4j<br>Spring Cloud Gateway |
| Distributed Lock | **Distributed Lock** | Đảm bảo chỉ một service xử lý một tài nguyên tại cùng một thời điểm. | Redis<br>HashiCorp Consul |
| Saga | **Saga Pattern** | Quản lý transaction giữa nhiều service bằng chuỗi local transaction và cơ chế rollback/compensation. | Axon Framework<br>Temporal<br>Apache Kafka |
| Event Bus | **Event-Driven Architecture (EDA)** | Các service giao tiếp thông qua Event thay vì gọi trực tiếp. | Apache Kafka<br>RabbitMQ |
| Authentication | **Authentication Service** | Xác minh danh tính người dùng (JWT, OAuth2, OpenID Connect...). | Keycloak<br>Auth0<br>Spring Security OAuth2 |
| Authorization | **Authorization** | Kiểm tra quyền truy cập (Role-Based Access Control, Permission). | Spring Security<br>Keycloak |
| Monitoring | **Application Monitoring** | Theo dõi CPU, RAM, Request, Response Time, Error Rate... | Prometheus |
| Logging | **Centralized Logging** | Thu thập log của tất cả service về một nơi để tìm kiếm và phân tích. | Fluent Bit<br>Loki |
| Tracing | **Distributed Tracing** | Theo dõi toàn bộ hành trình của một request đi qua nhiều service. | OpenTelemetry<br>Jaeger<br>Zipkin |
| Metrics | **Metrics Collection** | Thu thập số liệu như request/sec, latency, memory, JVM metrics... | Micrometer<br>OpenTelemetry |
| Health Check | **Health Check** | Kiểm tra service còn hoạt động hay không. |  |
| Service Registry | **Service Registry** | Nơi lưu thông tin các service đã đăng ký (thường nằm trong Discovery Service). |  |
| Containerization | **Containerization** | Đóng gói service thành container để chạy nhất quán ở mọi môi trường. | Docker<br>Podman<br>LXC |
| Orchestration | **Container Orchestration** | Quản lý hàng trăm container: deploy, scale, rolling update, self-healing... | Kubernetes |
| CI/CD | **Continuous Integration / Continuous Deployment** | Tự động build, test và deploy khi có thay đổi code. | Jenkins<br>GitHub Actions<br>GitLab CI<br>Azure DevOps |
| Infrastructure as Code | **Infrastructure as Code (IaC)** | Quản lý hạ tầng bằng code thay vì thao tác thủ công. | Terraform<br>OpenTofu |
| Secret Management | **Secret Management** | Quản lý mật khẩu, API Key, JWT Secret, Database Password... | HashiCorp Vault<br>Kubernetes Secrets |
| Observability | **Observability** | Kết hợp Metrics + Logging + Tracing để quan sát toàn bộ hệ thống. |  |