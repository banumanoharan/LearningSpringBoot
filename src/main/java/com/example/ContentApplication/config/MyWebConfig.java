package com.example.ContentApplication.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyWebConfig {
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplateBuilder().build();
	}

}
