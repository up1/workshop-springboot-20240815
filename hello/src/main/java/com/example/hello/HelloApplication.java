package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(HelloApplication.class, args);
		System.out.println("# of beans=" + context.getBeanDefinitionCount());
	}

}
