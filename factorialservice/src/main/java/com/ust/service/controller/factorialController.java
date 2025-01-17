package com.ust.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/factorial")
public class factorialController {

	@GetMapping("/test")
	public String test() {
		return "tested";
	}
	@GetMapping("/fact/{num}")
	public String factorial(@PathVariable int num) {
		long f=1;
		while(num>0) {
			f*=num;
			num-=1;
		}
		return f+"";
	}
}
