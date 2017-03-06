package com.niit.ShoppingKart.Service;

import java.util.List;

import com.niit.ShoppingKart.Model.Category;

public interface CategoryService {
	public List<Category> getCategories();
	public Category getCatById(int categoryId);
	void update(Category category);

}
