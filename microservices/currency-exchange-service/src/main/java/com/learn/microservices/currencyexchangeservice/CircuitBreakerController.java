package com.learn.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	//@Retry(name = "sample-api",fallbackMethod = "hardCodedResponse")
	@CircuitBreaker(name = "default",fallbackMethod = "hardCodedResponse")
	// Rate Limiting is only allowing a certain amount of calls to an API over a certain period
	// @RateLimiter(name = "default")
	@Bulkhead(name = "sample-api")
	public String sampleApi() {
		logger.info("Sample API call received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/some-dummy-url", 
				String.class);
		return forEntity.getBody();
	}
	
	public String hardCodedResponse(Exception ex) {
		return "fallback-response";
	}
}
