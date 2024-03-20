package com.sri.service;

import com.sri.model.Customer;

public interface ICustomerService {

	boolean fetchCustomerData(String username, String password) throws Exception;

	public String register(Customer customer) throws Exception;
}
