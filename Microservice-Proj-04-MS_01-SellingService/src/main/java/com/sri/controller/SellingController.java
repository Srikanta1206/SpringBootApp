package com.sri.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sell")
@RefreshScope
public class SellingController {

	@Value("${db.username}")
	private String username;
	
	@GetMapping("/config")
	public String getProperties() {
		return "Username of Db is  :"+username;
	}
}
