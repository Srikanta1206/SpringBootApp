package com.sri.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/food")

public class OrderFood {

	@GetMapping("/order")
	@HystrixCommand(fallbackMethod = "userFriendlyMessage", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true") })
	public String orderFood() {
		System.out.println("OrderFood.orderFood()");

		if (new Random().nextInt(6) > 2)
			return "food is ordered successfully";

		throw new IllegalArgumentException();

	}

	public String userFriendlyMessage() {
		System.out.println("OrderFood.userFriendlyMessage()");
		return "Service is Not Availble!!!Site is under Maintance";
	}
}
