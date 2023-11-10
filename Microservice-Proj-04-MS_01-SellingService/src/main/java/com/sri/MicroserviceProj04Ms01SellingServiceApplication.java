package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProj04Ms01SellingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj04Ms01SellingServiceApplication.class, args);
	}

}
