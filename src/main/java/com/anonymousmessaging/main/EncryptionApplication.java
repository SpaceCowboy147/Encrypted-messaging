package com.anonymousmessaging.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages = "com.anonymousmessaging.*, com.anonymousmessaging.users.UserRepository")


@ComponentScan(basePackages = "com.anonymousmessaging.*, com.anonymousmessaging.users")
public class EncryptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncryptionApplication.class, args);
	}

}
