package com.lark.firstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ZodiacTellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZodiacTellerApplication.class, args);
	}

}
