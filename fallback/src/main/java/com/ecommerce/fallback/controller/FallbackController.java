package com.ecommerce.fallback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController { 
    @PostMapping("/fallback") 
    public Mono<String> fallback() { 
        return Mono.just("fallback-gateway"); 
    } 
}
