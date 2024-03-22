package com.sri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.model.Place;

@Controller
@RequestMapping("/scheduled")
public class ScheduledDetails {

	@PostMapping("/details")
	public String getDetails(@ModelAttribute Place Place) {
		return "details";
	}
}
