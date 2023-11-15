package edu.vikhani.springcloudwebinardemo.docgen.config;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.COUNT_BASED;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().rootUri("http://clientinfo:8081").build();
    }

    @Bean
    public CircuitBreakerConfigCustomizer ourSecondCircuitBreakerCircuitBreakerConfig() {
        return CircuitBreakerConfigCustomizer
                .of("ourSecondCircuitBreaker",
                        builder -> builder.slidingWindowSize(10)
                                .slidingWindowType(COUNT_BASED)
                                .waitDurationInOpenState(Duration.ofSeconds(3))
                                .minimumNumberOfCalls(5)
                                .failureRateThreshold(50.0f)
                                );
    }
}
