package com.ecommerce.apigateway.Filter;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
@Configuration
public class Resilience4jConfig  {

        /**
     * Default Resilience4j circuit breaker configuration
     */
    // @Bean
    // public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
    //     return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
    //             .circuitBreakerConfig(CircuitBreakerConfig.custom().minimumNumberOfCalls(5).failureRateThreshold(20).build())
    //             .build());
    // }
    

    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> myCircuitBreaker() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                                                .failureRateThreshold(60)
                                                .waitDurationInOpenState(Duration.ofMillis(10000))
                                                .minimumNumberOfCalls(2)
                                                .slidingWindowType(SlidingWindowType.COUNT_BASED)
                                                .slidingWindowSize(5)
                                                .build();
        return factory -> factory.configure(builder -> builder
                .circuitBreakerConfig(circuitBreakerConfig)
                .build(),"myCircuitBreaker");
    }

    

}
