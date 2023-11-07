package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceProj02MsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj02MsEurekaServerApplication.class, args);
	}

}
