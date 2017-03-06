package com.niit.ShoppingCart.Service;

import java.util.List;

import com.niit.ShoppingCart.Model.Category;

public interface CategoryService {
	List<Category> getCategories();
	public Category getCatById(int catId);
	void update(Category cat);

}
