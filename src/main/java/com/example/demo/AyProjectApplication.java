package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AyProjectApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AyProjectApplication.class);
		application.run(args);
//		SpringApplication.run(AyProjectApplication.class, args);
	}

}
