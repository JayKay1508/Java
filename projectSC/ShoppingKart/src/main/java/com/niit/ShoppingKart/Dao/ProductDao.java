package com.niit.ShoppingKart.Dao;

import java.util.List;

import com.niit.ShoppingKart.Model.Product;


public interface ProductDao {
	
	public List<Product> getProducts();
	
	public Product get(int productId);
	
	public void update(Product product);
	
	public void delete(int id);

	public List<Product> list();
}
