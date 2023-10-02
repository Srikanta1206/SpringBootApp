package com.sri.product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class ProductName {

	private Integer productTypeId;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "id",referencedColumnName = "product_id")
	private Product productname;
	private Integer qty;
	private Double price;
	
}
