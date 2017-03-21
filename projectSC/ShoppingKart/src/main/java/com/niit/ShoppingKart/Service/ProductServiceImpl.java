package com.niit.ShoppingKart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Model.Product;
import com.niit.ShoppingKart.Dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired	
	private ProductDao productDao;
	
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.getProducts();
	}

	@Transactional
	public Product get(int productId) {
		// TODO Auto-generated method stub
		return productDao.get(productId);
	}

	@Transactional
	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
		
	}

	@Transactional
	public void delete(int productId) {
		// TODO Auto-generated method stub
		productDao.delete(productId);

	}

	@Transactional
	public List<Product> list() {
		// TODO Auto-generated method stub
		return productDao.list();
	}

}
