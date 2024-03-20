package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class MicroserviceProj07CircutBreakerWithHystricsDahboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProj07CircutBreakerWithHystricsDahboardApplication.class, args);
	}

}
