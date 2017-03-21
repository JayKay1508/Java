package com.niit.ShoppingKart.Dao;

import java.util.List;

import com.niit.ShoppingKart.Model.Cart;

public interface CartDao {
	
	public List<Cart> list(int id);
	
	public List<Cart> list();
	
	public Cart get(int id);
	
	public void saveOrUpdate(Cart cart);
	
	
	public void delete(int cartId);

	public List<Cart> list(String username);
		
	public boolean itemAlreadyExist(int userId, int productId, boolean b);
	
	public Cart getByUserandProduct(int userId, int productId);
	


}
