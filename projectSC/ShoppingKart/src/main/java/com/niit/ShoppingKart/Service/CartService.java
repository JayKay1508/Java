package com.niit.ShoppingKart.Service;

import java.util.List;

import com.niit.ShoppingKart.Model.Cart;

public interface CartService {

	public List<Cart> list(int id);

	public List<Cart> list(String username);

	public List<Cart> list();

	public Cart get(int id);

	public void saveOrUpdate(Cart cart);

	public void delete(int cartId);

	public boolean itemAlreadyExist(int userId, int productId, boolean b);

	public Cart getByUserandProduct(int userId, int productId);

}
