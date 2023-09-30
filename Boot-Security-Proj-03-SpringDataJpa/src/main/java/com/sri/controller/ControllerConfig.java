package com.sri.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.entity.UserDetails;
import com.sri.model.UserRole;
import com.sri.service.IServiceMgmt;

@Controller
@RequestMapping("/user")
public class ControllerConfig {

	@Autowired
	private IServiceMgmt service;//injecting service class obj

	@GetMapping("/registration")
	public String getRegisterPage(@ModelAttribute UserRole details) {	
		return "Registration";
	}
	
	
	@PostMapping("/registration")
	public String getRegistrationSuccess(Map<String,Object> map,UserDetails details) {
		String result=service.register(details);
		map.put("result", result);
		return "success";
	}
	
	//for failure login page
	@PostMapping("/loginDenied")
	public String getFailure() {
		return "loginDenied";
	}
	
	@GetMapping("/show_login")
	public String getLoginPage() {
		return "custom_login";
	}
	
	//Working with reference data like List,set,Map,Array
	@ModelAttribute("rolesinfo")
	public String[] getRole() {
		String[] roles=new String[] {"Manager","Clerk","Customer","Admin"};
		return roles;
	}
}
