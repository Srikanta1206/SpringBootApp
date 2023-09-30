package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BootSecurityProj03SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSecurityProj03SpringDataJpaApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getEncoderPassword() {
		return new BCryptPasswordEncoder();
	}

}
