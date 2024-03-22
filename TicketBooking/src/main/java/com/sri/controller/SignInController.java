package com.sri.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.model.Customer;
import com.sri.model.Place;
import com.sri.service.ICustomerService;

@Controller
@RequestMapping("/signIn")
public class SignInController {

	@Autowired
	private ICustomerService service;

	@GetMapping("/signin")
	public String home() {
		return "signIn";
	}

	@PostMapping("/signin")
	public String completeSignIn(@ModelAttribute Customer customer,@ModelAttribute Place place) {
		if (!customer.getUsername().isEmpty()) {
			if (!customer.getPassword().isEmpty()) {
				return "search";
			}
		}
		return "redirect:signin";
	}

	@GetMapping("/register")
	public String lunchRegister(@ModelAttribute Customer customer, org.springframework.ui.Model model) {
		model.addAttribute("customer", customer);
		return "newregistration";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Customer customer, Map<String, Object> map) throws Exception {

		String message = service.register(customer);

		map.put("message", "Railway board will take care about your is data");
		return "registrationComplete";
	}
	
	@GetMapping("/contact")
	public String contactDetails() {
		return "contact";
	}
	
	@ModelAttribute("city")
	public Set<String> getCityName() {
		return Set.of("Berhampur-BAM","Bhubaneswar-BBS");
	}
}
