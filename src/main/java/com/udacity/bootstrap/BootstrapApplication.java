package com.udacity.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.udacity.bootstrap.responsehandlers.RestTemplateResponseErrorHandler;

@SpringBootApplication
public class BootstrapApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(BootstrapApplication.class, args);
	}

	@Bean
	public RestTemplateBuilder builder() {
		return new RestTemplateBuilder();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(new RestTemplateResponseErrorHandler())
			.build();
	}

}
