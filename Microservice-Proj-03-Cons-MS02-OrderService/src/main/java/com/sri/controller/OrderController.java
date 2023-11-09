package com.sri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.client_type_comp.IConsumerClientTpe;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IConsumerClientTpe client;

	@GetMapping("/item")
	public String makeOrder() {
		ResponseEntity<String> message = new ResponseEntity<String>(
				"Item is Ready for Delivery!!!Pleanse Make Payment :" + client.getBpaymentInfo("2005204054"),
				HttpStatus.CREATED);
		String[] m_body = message.getBody().split(":");
		return m_body[0];
	}
}
