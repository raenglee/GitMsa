package com.green.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients	// 오픈 페인 사용 가능
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

}
