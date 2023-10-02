package com.sri.prod.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.product.Product;

public interface OracleProdRepo extends JpaRepository<Product, Integer> {

}
