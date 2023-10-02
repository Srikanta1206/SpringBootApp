package com.sri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.prod.repo.OracleProdRepo;
import com.sri.product.Product;

@Service
public class ProductServiceMgmtImpl implements IServiceMgmt {

	@Autowired
	private OracleProdRepo repo;
	
	@Override
	public String addProductDetails(Product pro) throws Exception {
		return repo.save(pro).getId()+" Saved Successfully";
	}

}
