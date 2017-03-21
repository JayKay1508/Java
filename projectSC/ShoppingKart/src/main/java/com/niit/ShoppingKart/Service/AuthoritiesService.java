package com.niit.ShoppingKart.Service;

import java.util.List;

import com.niit.ShoppingKart.Model.Authorities;

public interface AuthoritiesService {
	
	public Authorities get(String username);
	
	public Authorities getRole(String username);

	public List<Authorities> list();	
	
	public void saveOrUpdate(Authorities authorities);
		


}
