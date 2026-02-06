package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		System.out.println(System.getenv("Esta es la url de mi base de datos"+"DB_URL"));
		System.out.println(System.getenv("Esta es el usuario de mi base de datos"+"DB_USERNAME"));
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
