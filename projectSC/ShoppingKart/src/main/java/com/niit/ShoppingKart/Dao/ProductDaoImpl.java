package com.niit.ShoppingKart.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.Product;
@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Product> getProducts() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> products=query.list();
		session.flush();
		session.close();
		return products;
	}

	@Transactional
	public Product get(int productId) {
		Session session = sessionFactory.getCurrentSession();
		return (Product) session.get(Product.class, productId);	
	}
	
	@Transactional
	public List<Product> list() {
		@SuppressWarnings({ "unchecked" })
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}

	
	@Transactional
	public void update(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		
	}

	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, id);
		session.delete(product);
		session.flush();
		session.close();		
	}

}
