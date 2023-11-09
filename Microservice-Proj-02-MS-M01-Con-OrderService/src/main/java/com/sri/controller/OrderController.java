package com.sri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.utility.HelperClientConsumer;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private HelperClientConsumer clientConsumer;
	
	@GetMapping("/shopping/order")
	public String placeOrder() {
		return "Order was placed !!Please make sure about your payment  :\n"+clientConsumer.discoveryClient();
	}
}
