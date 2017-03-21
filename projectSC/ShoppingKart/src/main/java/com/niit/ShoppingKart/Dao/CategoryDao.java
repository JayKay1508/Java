package com.niit.ShoppingKart.Dao;

import java.io.IOException;
import java.util.List;

import com.niit.ShoppingKart.Model.Category;

public interface CategoryDao {
	
	public List<Category> getCategories();
	
	public Category getCatById (int categoryId);
	
	public void delete(int id);
	
	public Category validate(int categoryId) throws IOException;
	
	void update(Category category);
	
}
