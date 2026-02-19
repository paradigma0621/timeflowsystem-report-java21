package com.paradigma0621.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EurekaClient // In Spring Boot 3.x + Spring Cloud 2023.x, it is no longer necessary to use @EurekaClient.
public class ReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportApplication.class, args);
	}

}
