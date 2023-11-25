package com.anonymousmessaging.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity

@ComponentScan(basePackages = "com.anonymousmessaging.security")
public class EncryptionApplication {


	public static void main(String[] args) {
		SpringApplication.run(EncryptionApplication.class, args);
	}

}
