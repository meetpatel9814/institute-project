package com.institute.spring.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.institute")
@SpringBootApplication
@EntityScan(basePackages = "com.institute")
public class InstituteBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstituteBaseApplication.class, args);
	}

}
