package com.ust.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
@RequestMapping("/rest/service")
public class HelloController {
	
	private static final String CLIENT_SERVICE = "clientService";
	@Autowired
	RestTemplate template;
	
	@GetMapping("/circuit")
	@CircuitBreaker(name=CLIENT_SERVICE,fallbackMethod = "callOnFall")
	public String failTest() {
		String url = "http://localhost:8094/service/default";
		String output = template.getForObject(url, String.class);
		return output;
	}
	
	public String callOnFall(Exception e) {
		return "service not available";
	}
}
