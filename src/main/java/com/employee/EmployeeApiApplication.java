package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.employee")
public class EmployeeApiApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiApplication.class, args);
		System.out.println("Server Started.....");
	}

}
