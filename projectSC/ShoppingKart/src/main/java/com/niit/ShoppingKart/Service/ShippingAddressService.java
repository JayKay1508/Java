package com.niit.ShoppingKart.Service;

import java.io.IOException;
import java.util.List;

import com.niit.ShoppingKart.Model.ShippingAddress;

public interface ShippingAddressService {
	
public List<ShippingAddress> getShippingAddress();
	
	public ShippingAddress get(int shippingId);
	
	public ShippingAddress validate(int shippingId) throws IOException;
	
	public void update(ShippingAddress shippingAddress);
	
	public void delete(int shippingId);

}
