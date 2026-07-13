service {
  name = "order-service"
  id = "order-service"
  address = "172.30.0.22"
  port = 8082

  check {
    id = "order-service-health"
    name = "order-service HTTP health"
    http = "http://order-service:8082/actuator/health"
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
          }
        ]
      }
    }
  }
}
