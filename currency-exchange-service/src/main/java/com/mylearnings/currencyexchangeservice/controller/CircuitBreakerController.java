package com.mylearnings.currencyexchangeservice.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public String sampleApi(){
        logger.info(" CircuitBreakerController :: sampleApi method ");
        /*ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:9000/sample-dummy-api", String.class);
        return responseEntity.getBody();*/
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex){
        return "hardcoded-response";
    }

}
