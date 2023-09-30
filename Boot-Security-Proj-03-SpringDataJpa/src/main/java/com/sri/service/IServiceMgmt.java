package com.sri.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sri.entity.UserDetails;

public interface IServiceMgmt extends UserDetailsService{

	//adding in oracle database (already cfg oracle in properties)
	String register(UserDetails details);
}
