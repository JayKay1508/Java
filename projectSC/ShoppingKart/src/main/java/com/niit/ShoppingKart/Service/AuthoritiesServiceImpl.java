package com.niit.ShoppingKart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Dao.AuthoritiesDao;
import com.niit.ShoppingKart.Model.Authorities;
@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{
	
	@Autowired
	private AuthoritiesDao authoritiesDao;
	
	@Transactional
	public Authorities get(String username) {
		return authoritiesDao.get(username);
	}

	@Transactional
	public List<Authorities> list() {
		// TODO Auto-generated method stub
		return authoritiesDao.list();
	}

	@Transactional
	public void saveOrUpdate(Authorities authorities) {
		authoritiesDao.saveOrUpdate(authorities);
		
	}

	@Transactional
	public Authorities getRole(String username) {
		// TODO Auto-generated method stub
		return authoritiesDao.getRole(username);
	}

}
