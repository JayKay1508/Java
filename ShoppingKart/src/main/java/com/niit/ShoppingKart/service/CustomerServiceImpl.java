package com.niit.ShoppingKart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ShoppingKart.dao.CustomerDao;
import com.niit.ShoppingKart.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
private CustomerDao customerDao;
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

}