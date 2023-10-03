package com.sri.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.product.Product;
import com.sri.service.IServiceMgmt;
import com.sri.user.User;

@Component
public class RunnerApp implements CommandLineRunner {

	@Autowired
	private IServiceMgmt service;
	@Override
	public void run(String... args) throws Exception {
		Product p1=new Product();
		User u=new User();
		p1.setName("Electric");
		u.setContactno(9776705368l);
		u.setMail("sksabat@12gmail.com");
		u.setName("Srikanta Kumar Sabata");
		System.out.println(service.addProductDetails(p1,u));
	}
}
