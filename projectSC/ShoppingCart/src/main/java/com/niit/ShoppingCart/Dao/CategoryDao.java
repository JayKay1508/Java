package com.niit.ShoppingCart.Dao;

import java.io.IOException;
import java.util.List;

import com.niit.ShoppingCart.Model.Category;

public interface CategoryDao {
	public List<Category> getCategories();
	public Category getCatById (int catId);
	public Category validate(int catId) throws IOException;
	void update(Category category);
	}
