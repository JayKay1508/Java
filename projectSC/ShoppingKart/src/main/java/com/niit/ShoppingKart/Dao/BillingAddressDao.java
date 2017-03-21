package com.niit.ShoppingKart.Dao;

import java.io.IOException;
import java.util.List;

import com.niit.ShoppingKart.Model.BillingAddress;


public interface BillingAddressDao {
		
		public List<BillingAddress> getBillingAddresss();
		
		public BillingAddress get(int billingId);
		
		public BillingAddress validate(int billingId) throws IOException;
		
		public void update(BillingAddress billingAddress);
		
		public void delete(int billingId);
}
