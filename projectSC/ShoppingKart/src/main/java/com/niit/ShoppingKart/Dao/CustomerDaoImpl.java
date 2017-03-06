package com.niit.ShoppingKart.Dao;


import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.Category;
import com.niit.ShoppingKart.Model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
private SessionFactory sessionFactory;

	@Transactional
	public List<Customer> getCustomers() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Customer");
		List<Customer> customer=query.list();
		session.close();
		return customer;
	}

	@Transactional
	public Customer getCustById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
	}

	@Transactional
	public Customer validate(int customerId) throws IOException {
		Customer customer=getCustById(customerId);
		return customer;
	}

	@Transactional
	public void update(Customer customer) {
		int customerId = customer.getId();
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
	    session.saveOrUpdate(customer);
		
	}

}


