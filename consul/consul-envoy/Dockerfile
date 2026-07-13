FROM hashicorp/consul:1.21 AS consul

FROM envoyproxy/envoy:v1.33-latest
COPY --from=consul /bin/consul /usr/local/bin/consul
ENV PATH="/usr/local/bin:/usr/bin:${PATH}"
