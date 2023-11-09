package com.sri.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.model.CardDetails;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@GetMapping("/billInfo/{paymentId}")
	public ResponseEntity<String> paymentInfo(@PathVariable String paymentId){
		return new ResponseEntity<String>("Make Seamless Payment",HttpStatus.OK);
	}
	@PostMapping("/payBill")
	public ResponseEntity<String> makePayment(@RequestBody CardDetails details){
		//use UniversalPaymentBroker code
		return new ResponseEntity<String>("Make payment",HttpStatus.ACCEPTED);
	}
}
