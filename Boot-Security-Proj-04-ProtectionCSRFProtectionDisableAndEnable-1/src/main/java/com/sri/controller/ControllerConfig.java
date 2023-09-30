package com.sri.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class ControllerConfig {

	@GetMapping
	public String getMapping() {
		return "home";
	}
	@PostMapping("/withdraw")
	public String getWithdrawAmountIn(Map<String,Object> map) {
		String s1=new Random().nextInt(1000, 9999998)+" withdraw successfully";
		map.put("withdraw", s1);
		return "withdraw";
	}
	@GetMapping("/withdraw")
	public String getWithdrawAmount(Map<String,Object> map) {
		String s1=new Random().nextInt(1000, 9999998)+" withdraw successfully";
		map.put("withdraw", s1);
		return "withdraw";
	}
	
}
