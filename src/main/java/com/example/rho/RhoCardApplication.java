package com.example.rho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.rho")
public class RhoCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhoCardApplication.class, args);
	}

}
