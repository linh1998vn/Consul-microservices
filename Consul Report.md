# Consul

Project: Consul report (https://app.notion.com/p/Consul-report-39c16c9730a6802ea9b2fcea4f5eba5b?pvs=21)
Status: Not started
Text: Báo cáo consul

## Những chức năng đã cài:

### Consul:

- Consul Server:
- Trung tâm quản lý service discovery và service mesh.
- Được cấu hình trong docker-compose để chạy khi dùng docker.
- Consul UI:
- Giao diện để xem service nào đã đăng ký, health check, sidecar proxy, intentions.
- UI được tích hợp sẵn trong Consul Server và được bật trong docker-compose.
- Consul Service Discovery:
- Các service được đăng ký vào Consul qua file:
     consul/services/api-gateway.hcl
     consul/services/product-service.hcl
     consul/services/order-service.hcl
- Consul Health Check:
- Consul dùng check này để biết service sống/chết.
- Consul Connect:
- Nó giúp các service giao tiếp với nhau qua proxy sidecar.
- Được bật tại consul/agent.hcl
- Các chức năng chính:
    + Service-to-service communication: Cho phép service gọi nhau thông qua mesh.
    + Sidecar proxy: Mỗi service có một proxy đứng cạnh, ở project này là Envoy.
    + mTLS: Hỗ trợ mã hóa và xác thực service-to-service bằng certificate.
    + Intentions: Quy định service nào được gọi service nào.
    + Traffic control: Kết hợp với Envoy để route, timeout, retry, load balancing, observability.

### API Gateway:

Những depeenddencies đã sử dụng:

- Spring Cloud Gateway
- Spring Boot WebFlux
- Reactor Netty
- Spring Cloud Consul
- Spring Boot Actuator
- Envoy Sidecar
- Docker