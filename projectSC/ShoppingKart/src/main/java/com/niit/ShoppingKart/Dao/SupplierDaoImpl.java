package com.niit.ShoppingKart.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Transactional
	public List<Supplier> getSuppliers() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> suppliers=query.list();
		session.close();
		return suppliers;
	}

	@Transactional
	public Supplier get(int supplierId) {
		Session session = sessionFactory.getCurrentSession();
		return (Supplier) session.get(Supplier.class, supplierId);	
		}

	@Transactional
	public void update(Supplier supplier) {
		
		Session session = sessionFactory.getCurrentSession();
	    session.saveOrUpdate(supplier);
		
	}

	@Transactional
	public void delete(int supplierId) {
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setId(supplierId);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
		// TODO Auto-generated method stub
		
	}

}
