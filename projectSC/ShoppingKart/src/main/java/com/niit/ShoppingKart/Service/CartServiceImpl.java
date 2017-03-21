package com.niit.ShoppingKart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Dao.CartDao;
import com.niit.ShoppingKart.Model.Cart;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	@Transactional
	public List<Cart> list(int id) {
		// TODO Auto-generated method stub
		return cartDao.list(id);
	}

	@Transactional
	public List<Cart> list() {
		// TODO Auto-generated method stub
		return cartDao.list();
	}

	@Transactional
	public Cart get(int id) {
		// TODO Auto-generated method stub
		return cartDao.get(id);
	}

	@Transactional
	public void saveOrUpdate(Cart cart) {
		cartDao.saveOrUpdate(cart);
		
	}

	@Transactional
	public void delete(int cartId) {
		cartDao.delete(cartId);
		
	}

	@Transactional
	public List<Cart> list(String username) {
		// TODO Auto-generated method stub
		return cartDao.list(username);
		
	}

	@Transactional
	public boolean itemAlreadyExist(int userId, int productId, boolean b) {
		// TODO Auto-generated method stub
		return cartDao.itemAlreadyExist(userId, productId, b);
	}

	@Transactional
	public Cart getByUserandProduct(int userId, int productId) {
		// TODO Auto-generated method stub
		return cartDao.getByUserandProduct(userId, productId);
	}

}
