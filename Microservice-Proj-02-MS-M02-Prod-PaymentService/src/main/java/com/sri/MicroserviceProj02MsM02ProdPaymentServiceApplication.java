package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProj02MsM02ProdPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj02MsM02ProdPaymentServiceApplication.class, args);
	}
	@Bean
	public RestTemplate getTemplateObj() {
		return new RestTemplate();
	}

}
