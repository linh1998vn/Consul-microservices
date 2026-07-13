service {
  name = "api-gateway"
  id = "api-gateway"
  address = "172.30.0.20"
  port = 8080

  check {
    id = "api-gateway-health"
    name = "api-gateway HTTP health"
    http = "http://api-gateway:8080/actuator/health"
    interval = "10s"
    timeout = "3s"
  }

  connect {
    sidecar_service {
      proxy {
        upstreams = [
          {
            destination_name = "product-service"
            local_bind_address = "0.0.0.0"
            local_bind_port = 19001
          },
          {
            destination_name = "order-service"
            local_bind_address = "0.0.0.0"
            local_bind_port = 19002
          }
        ]
      }
    }
  }
}
