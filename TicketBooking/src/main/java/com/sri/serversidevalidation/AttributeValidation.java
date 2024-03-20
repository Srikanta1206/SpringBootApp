package com.sri.serversidevalidation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sri.model.Customer;

public class AttributeValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Customer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer cust=(Customer)target;
		
	}
}
