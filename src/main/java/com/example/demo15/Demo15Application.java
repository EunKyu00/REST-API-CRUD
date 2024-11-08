package com.example.demo15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Demo15Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo15Application.class, args);
	}

}
