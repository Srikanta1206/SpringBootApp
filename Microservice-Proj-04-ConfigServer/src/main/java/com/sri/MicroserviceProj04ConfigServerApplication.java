package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer      
public class MicroserviceProj04ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj04ConfigServerApplication.class, args);
	}

}
