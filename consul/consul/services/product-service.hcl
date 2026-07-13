service {
  name = "product-service"
  id = "product-service"
  address = "172.30.0.21"
  port = 8081

  check {
    id = "product-service-health"
    name = "product-service HTTP health"
    http = "http://product-service:8081/actuator/health"
    interval = "10s"
    timeout = "3s"
  }

  connect {
    sidecar_service {}
  }
}
