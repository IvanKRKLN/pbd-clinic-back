package com.example.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.clinic.repositories.statistics", "com.example.clinic.repositories"})
public class ClinicApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClinicApplication.class, args);
	}
}

