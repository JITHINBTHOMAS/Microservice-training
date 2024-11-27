package com.ust.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HellloclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellloclientApplication.class, args);
	}

	@Bean
	public RestTemplate newTemplate() {
		return new RestTemplate();
	}
}
