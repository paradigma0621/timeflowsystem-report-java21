package com.paradigma0621.report;

import com.netflix.discovery.EurekaClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EurekaClient No Spring Boot 3.x + Spring Cloud 2023.x, não precisa mais usar @EurekaClient.
public class ReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportApplication.class, args);
	}

}
