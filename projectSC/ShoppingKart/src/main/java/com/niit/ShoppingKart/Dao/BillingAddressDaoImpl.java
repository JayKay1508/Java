package com.niit.ShoppingKart.Dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.BillingAddress;



@Repository
public class BillingAddressDaoImpl implements BillingAddressDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<BillingAddress> getBillingAddresss() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from BillingAddress");
		List<BillingAddress> billingAddress=query.list();
		session.close();
		return billingAddress;
	}

	@Transactional
	public BillingAddress get(int billingId) {
		Session session = sessionFactory.getCurrentSession();
		return (BillingAddress) session.get(BillingAddress.class, billingId);	
	}

	@Transactional
	public BillingAddress validate(int billingId) throws IOException {
		BillingAddress billingAddress=get(billingId);
		return billingAddress;
	}

	@Transactional
	public void update(BillingAddress billingAddress) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(billingAddress);
		
	}

	@Override
	public void delete(int billingid) {
		// TODO Auto-generated method stub
		
	}

	

}
