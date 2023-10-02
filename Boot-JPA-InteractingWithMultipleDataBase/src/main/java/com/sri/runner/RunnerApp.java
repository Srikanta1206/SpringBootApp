package com.sri.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sri.product.Product;
import com.sri.service.IServiceMgmt;

@Component
public class RunnerApp implements CommandLineRunner {

	@Autowired
	private IServiceMgmt service;
	@Override
	public void run(String... args) throws Exception {
		Product p1=new Product();
		p1.setName("Srikanta");
		System.out.println(service.addProductDetails(p1));
	}
}
