package com.niit.ShoppingKart.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Dao.BillingAddressDao;
import com.niit.ShoppingKart.Model.BillingAddress;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {
	@Autowired
	private BillingAddressDao billingAddressDao;
	@Transactional
	public List<BillingAddress> getBillingAddresss() {
		// TODO Auto-generated method stub
		return billingAddressDao.getBillingAddresss();
		
	}

	@Transactional
	public BillingAddress get(int billingId) {
		// TODO Auto-generated method stub
		return billingAddressDao.get(billingId);
	}

	@Transactional
	public void update(BillingAddress billingAddress) {
		// TODO Auto-generated method stub
		billingAddressDao.update(billingAddress);
		
	}

	@Transactional
	public void delete(int billingId) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public BillingAddress validate(int billingId) throws IOException {
		// TODO Auto-generated method stub
		return billingAddressDao.validate(billingId);
	}

}
