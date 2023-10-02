package com.sri.product;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@Transient
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "id",referencedColumnName = "product_id")
	private Set<String> type;
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getType() {
		return type;
	}
	public void setType(Set<String> type) {
		this.type = type;
	}
	
	
}
