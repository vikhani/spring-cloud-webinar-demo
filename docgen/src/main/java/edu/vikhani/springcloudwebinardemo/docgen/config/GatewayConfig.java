package edu.vikhani.springcloudwebinardemo.docgen.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f ->
                                f.addRequestHeader("Docgen", "routed request")
                        )
                        .uri("http://httpbin.org:80"))
                // curl --dump-header - --header 'Host: www.ourcircuitbreaker.com' http://localhost:8082/delay/20
                .route(p -> p
                        .host("*.ourcircuitbreaker.com")
                        .filters(f ->
                                f.circuitBreaker(config ->
                                        config.setName("ourCircuitBreaker").setFallbackUri("forward:/fallback"))
                        )
                        .uri("http://httpbin.org:80"))
                .build();
    }
}