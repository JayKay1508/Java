package com.niit.ShoppingKart.Service;

import java.util.List;

import com.niit.ShoppingKart.Model.Product;

public interface ProductService {

	public List<Product> getProducts();
	
	public Product get(int productId);
	
	public void update(Product product);
	
	public void delete(int productId);

	public List<Product> list();
}
