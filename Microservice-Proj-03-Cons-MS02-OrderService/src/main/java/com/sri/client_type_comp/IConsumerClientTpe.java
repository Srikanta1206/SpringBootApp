package com.sri.client_type_comp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Payment-Service")
public interface IConsumerClientTpe {

	@GetMapping("/payment/billInfo/{paymentId}")
	public ResponseEntity<String> getBpaymentInfo(@PathVariable String paymentId);
	
}
