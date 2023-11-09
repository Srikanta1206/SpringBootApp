package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceProj03EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj03EurekaServerApplication.class, args);
	}

}
