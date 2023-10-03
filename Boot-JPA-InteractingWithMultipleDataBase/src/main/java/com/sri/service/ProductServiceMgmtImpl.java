package com.sri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.prod.repo.OracleProdRepo;
import com.sri.product.Product;
import com.sri.user.User;
import com.sri.user.repo.UserRepo;

@Service
public class ProductServiceMgmtImpl implements IServiceMgmt {

	@Autowired
	private OracleProdRepo repo;
	
	@Autowired
	private UserRepo repo1;
	
	@Override
	public String addProductDetails(Product pro,User user) throws Exception {
		User u=repo1.save(user);
		Integer id=u.getId();
		return repo.save(pro).getId()+" Saved Successfullly"+" User id is  :"+id;
	}

}
