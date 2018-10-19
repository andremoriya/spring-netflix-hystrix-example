package io.icodetech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class HystrixExampleApp {
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixExampleApp.class, args);
	}
	
}
