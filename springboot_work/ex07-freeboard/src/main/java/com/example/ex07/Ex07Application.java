package com.example.ex07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Ex07Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
		SpringApplication.run(Ex07Application.class, args);

		Arrays.stream(applicationContext.getBeanDefinitionNames())
				.forEach(System.out::println);
	}
}