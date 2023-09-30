package com.sri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankingOfferControl {

	@GetMapping
	public String getHome() {
		return "home";
	}

	@GetMapping("/balance")
	public String getBalance() {
		return "balance";
	}
}
