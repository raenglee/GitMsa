package com.example.ex09;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing  //자동 날짜 기입
public class Ex09Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
		SpringApplication.run(Ex09Application.class, args);

//		Arrays.stream(applicationContext.getBeanDefinitionNames())
//				.forEach(System.out::println);
	}

	@Bean
	public ModelMapper modelMApper(){
		return new ModelMapper();
	}
}