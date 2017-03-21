package com.niit.ShoppingKart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Dao.CustomerDao;
import com.niit.ShoppingKart.Model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Transactional
	public Customer getCustById(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustById(customerId);
	}

	@Transactional
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	@Transactional
	public Customer get(String username) {
		// TODO Auto-generated method stub
		return customerDao.get(username);
	}

	@Transactional
	public boolean CustomerAlreadyExist(String email, boolean b) {
		// TODO Auto-generated method stub
		return customerDao.CustomerAlreadyExist(email, b);
	}

}
