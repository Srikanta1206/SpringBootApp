package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProj03ProdMs01PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj03ProdMs01PaymentServiceApplication.class, args);
	}

}
