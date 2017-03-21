package com.niit.ShoppingKart.Dao;

import java.io.IOException;
import java.util.List;

import com.niit.ShoppingKart.Model.ShippingAddress;


public interface ShippingAddressDao {
	
	public List<ShippingAddress> getShippingAddresss();
	
	public ShippingAddress get(int shippingId);
	
	public ShippingAddress validate(int shippingId) throws IOException;
	
	public void update(ShippingAddress shippingAddress);
	
	public void delete(int shippingId);

}
