package com.niit.ShoppingKart.Dao;

import java.io.IOException;
import java.util.List;

import com.niit.ShoppingKart.Model.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();
	public Customer getCustById (int customerId);
	public Customer validate(int customerId) throws IOException;
	void update(Customer customer);

}
