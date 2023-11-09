package com.sri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/payment","/bill","/make/payment"})
public class PaymentController {

	@GetMapping(path = {"/payBill","/card_payment","/pay"})
	public ResponseEntity<?> payBill() {
		return new ResponseEntity<String>("We accept all type of payment",HttpStatus.OK);
	}
}
