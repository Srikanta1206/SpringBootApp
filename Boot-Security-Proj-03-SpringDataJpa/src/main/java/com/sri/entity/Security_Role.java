package com.sri.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Security_Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	@Column(length = 30,nullable = false)
	private String role;
	
}
