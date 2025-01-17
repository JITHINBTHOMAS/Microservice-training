package com.ust.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class HelloController {

	@Autowired
	RestTemplate template;
	
	@GetMapping("/confirm")
	public String connect() {
		String url = "http://localhost:8073/rest/service/getConfirmation";
		String list = template.getForObject(url, String.class);
		return list;
	}
	
	@GetMapping("/fact/{num}")
	public String factorial(@PathVariable int num) {
		String url = "http://localhost:8073/rest/factorial/fact/"+num;
		String list = template.getForObject(url, String.class);
		return list;
	}
}
