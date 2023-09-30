package com.sri.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerConfiguration {

	@GetMapping
	public String getHome() {
		return "home";
	}
	@GetMapping("/offer")
	public String getOffer(Map<String,Object> map) {
		return "offer";
	}
	
	@GetMapping("/withdraw")
	public String getWithdrawMoney(Map<String,Object> map) {
		return "withdraw";
	}
}
