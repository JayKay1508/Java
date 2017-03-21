package com.niit.ShoppingKart.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Dao.ShippingAddressDao;
import com.niit.ShoppingKart.Model.ShippingAddress;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService{
	@Autowired
	private ShippingAddressDao shippingAddressDao;
	
	@Transactional
	public List<ShippingAddress> getShippingAddress() {
		// TODO Auto-generated method stub
		return shippingAddressDao.getShippingAddresss();
	}
	
	@Transactional
	public ShippingAddress get(int shippingId) {
		// TODO Auto-generated method stub
		return shippingAddressDao.get(shippingId);
	}

	@Transactional
	public ShippingAddress validate(int shippingId) throws IOException {
		// TODO Auto-generated method stub
		return shippingAddressDao.validate(shippingId);
	}

	@Transactional
	public void update(ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		shippingAddressDao.update(shippingAddress);
		
	}

	@Transactional
	public void delete(int shippingId) {
		// TODO Auto-generated method stub
		
	}

	

}
