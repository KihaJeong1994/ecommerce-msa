package com.ecommerce.fallback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FallbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FallbackApplication.class, args);
	}

}
