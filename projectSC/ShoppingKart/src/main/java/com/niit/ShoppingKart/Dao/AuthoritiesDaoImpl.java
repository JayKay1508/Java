package com.niit.ShoppingKart.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.Authorities;

@Repository
public class AuthoritiesDaoImpl implements AuthoritiesDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public Authorities get(String username) {
		String hql = "from Authorities where username ='"+ username +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Authorities> listUser = (List<Authorities>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public List<Authorities> list() {
		@SuppressWarnings({ "unchecked" })
		List<Authorities> listAuthorities = (List<Authorities>)
		sessionFactory.getCurrentSession().createCriteria(Authorities.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listAuthorities;
	}

	@Transactional
	public Authorities getRole(String username) {
		String hql = "from Authorities where username ='"+ username +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Authorities> listUser = (List<Authorities>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Authorities authorities) {
		sessionFactory.getCurrentSession().saveOrUpdate(authorities);
		
	}
	

}
