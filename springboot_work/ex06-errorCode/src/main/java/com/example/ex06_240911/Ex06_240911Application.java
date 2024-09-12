package com.example.ex06_240911;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Ex06_240911Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
		SpringApplication.run(Ex06_240911Application.class, args);

		Arrays.stream(applicationContext.getBeanDefinitionNames())
				.forEach(System.out::println);
	}
}