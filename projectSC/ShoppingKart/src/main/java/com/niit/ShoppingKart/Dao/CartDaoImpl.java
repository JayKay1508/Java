package com.niit.ShoppingKart.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.Cart;
import com.niit.ShoppingKart.Model.Product;
@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Cart> list(int id) {
		String hql = "from Cart where userId=" + "'" + id + "'   and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		
		return list;
	}

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings({ "unchecked" })
		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		// TODO Auto-generated method stub
		return listCart;
	}

	@Transactional
	public Cart get(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Cart) session.get(Cart.class, id);	
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		
	}

	@Transactional
	public void delete(int cartId) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, cartId);
		session.delete(cart);
		session.flush();
		session.close();
	}

	@Transactional
	public List<Cart> list(String username) {
		String hql = "from Cart where userName=" + "'" + username + "'   and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		
		return list;
	}
	
	@Transactional
	public boolean itemAlreadyExist(int userId, int productId, boolean b) {
		String hql = "from Cart where userId= '" + userId + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}


	@Transactional
	public Cart getByUserandProduct(int userId, int productId) {
		String hql = "from Cart where userId= '" + userId + "' and " + " productId ='" + productId+"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();
		
		if (listCart != null && !listCart.isEmpty()){
			return listCart.get(0);
		}
		return null;
	}
	
	
	
}
