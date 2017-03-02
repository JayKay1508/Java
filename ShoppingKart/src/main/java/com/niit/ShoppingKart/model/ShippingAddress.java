package com.niit.ShoppingKart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ShippingAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
	@NotEmpty(message="Please enter Apartment Number")
private String apartmentNumber;
	@NotEmpty(message="Please enter Street Name")
private String streetName;
	@NotEmpty(message="Please enter City")
private String city;
	@NotEmpty(message="Please enter State")
private String State;
	@NotEmpty(message="Please enter Country")
private String country;
	@NotEmpty(message="Please enter Zip-Code")
private String zipcode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}