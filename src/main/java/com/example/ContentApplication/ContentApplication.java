package com.example.ContentApplication;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ContentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ContentApplication.class, args);
		/*System.out.println("****************************************************");
		System.out.println("Number of bean definitions:"+context.getBeanDefinitionCount());
		System.out.println("****************************************************");
		//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		RestTemplate template = (RestTemplate)context.getBean("getRestTemplate");
		System.out.println(template.toString());*/
		}

}
