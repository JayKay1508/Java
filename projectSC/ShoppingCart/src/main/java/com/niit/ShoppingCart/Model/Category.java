package com.niit.ShoppingCart.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "category")
@Component
public class Category {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String categoryDetails;
		
	public String getCategoryDetails() {
		return categoryDetails;
	}
	public void setCategoryDetails(String categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return this.id + " " + this.categoryDetails;
	}

	
	
	
}
