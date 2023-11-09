package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProj02MsM01ConOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj02MsM01ConOrderServiceApplication.class, args);
	}
	@Bean("restTemplate")
	public RestTemplate createTemplateObj() {
		return new RestTemplate();
	}
	

}
