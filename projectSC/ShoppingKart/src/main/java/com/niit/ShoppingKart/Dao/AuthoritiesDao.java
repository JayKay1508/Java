package com.niit.ShoppingKart.Dao;

import java.util.List;

import com.niit.ShoppingKart.Model.Authorities;

public interface AuthoritiesDao {
	
	public Authorities get(String username);

	public List<Authorities> list();	
	
	public Authorities getRole(String username);
	
	public void saveOrUpdate(Authorities authorities);

}
