package com.niit.ShoppingKart.Dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.ShippingAddress;
@Repository
public class ShippingAddressDaoImpl implements ShippingAddressDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public List<ShippingAddress> getShippingAddresss() {
		
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from ShippingAddress");
		List<ShippingAddress> shippingAddress=query.list();
		session.close();
		return shippingAddress;
	}

	@Transactional
	public ShippingAddress get(int shippingId) {
		
		Session session = sessionFactory.getCurrentSession();
		return (ShippingAddress) session.get(ShippingAddress.class, shippingId);
	}

	@Transactional
	public void update(ShippingAddress shippingAddress) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(shippingAddress);
		
	}

	@Transactional
	public void delete(int shippingId) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public ShippingAddress validate(int shippingId) throws IOException {
		
		ShippingAddress shippingAddress=get(shippingId);
		return shippingAddress;
	}

}
