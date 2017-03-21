package com.niit.ShoppingKart.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

	@Entity
	@Table(name="Authorities")
	@Component
	public class Authorities {
		@Id
		@GeneratedValue(generator = "newGenerator")
		@GenericGenerator(name = "newGenerator", strategy = "foreign", parameters = {
		@Parameter(value = "customer", name = "property") })
		private int id;
		
		
		
	@Column(unique=true)
	private String username;
	private String role;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Customer customer;
	
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
