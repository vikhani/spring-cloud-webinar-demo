package edu.vikhani.springcloudwebinardemo.gateway.config;

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
                .route(r -> r.path("/get")
                        .filters(f -> f.setPath("/doc/client").addResponseHeader("HELLO", "added-header-val"))
                        .uri("lb://DOCGEN"))
                // curl --dump-header - --header 'sus-header: hehe' http://localhost:8080/delay/20
                .route(p -> p
                        .header("sus-header")
                        .filters(f ->
                                f.circuitBreaker(config ->
                                        config.setName("ourCircuitBreaker").setFallbackUri("forward:/fallback"))
                        )
                        .uri("http://httpbin.org:80"))
                .build();
    }
}