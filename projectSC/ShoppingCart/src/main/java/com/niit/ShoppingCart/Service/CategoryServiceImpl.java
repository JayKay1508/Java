package com.niit.ShoppingCart.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ShoppingCart.Dao.CategoryDao;
import com.niit.ShoppingCart.Model.Category;
import com.niit.ShoppingCart.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
private CategoryDao categoryDao;
	
	public List<Category>getCategories(){
		return categoryDao.getCategories();
	}
	@Transactional	
	public Category getCatById(int categoryId) {
		
		// TODO Auto-generated method stub
		return categoryDao.getCatById(categoryId);
	}

	@Transactional
	public void update(Category category) {
		categoryDao.update(category);
		// TODO Auto-generated method stub
		
	}

}
