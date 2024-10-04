package com.example.ex10;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  //자동 날짜 기입
public class Ex10Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext
				= SpringApplication.run(Ex10Application.class, args);

//		Arrays.stream(applicationContext.getBeanDefinitionNames())
//				.forEach(System.out::println);

	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}