package com.niit.ShoppingKart.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ShoppingKart.Dao.CategoryDao;
import com.niit.ShoppingKart.Model.Category;
import com.niit.ShoppingKart.Service.CategoryService;

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
	@Transactional
	public void delete(int id) {
		categoryDao.delete(id);
		// TODO Auto-generated method stub
		
	}

}
