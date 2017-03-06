package com.niit.ShoppingCart.Dao;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ShoppingCart.Dao.CategoryDao;
import com.niit.ShoppingCart.Model.Category;
@Repository
public class CategoryDaoImpl implements CategoryDao {
@Autowired
private SessionFactory sessionFactory;
@SuppressWarnings("unchecked")
@org.springframework.transaction.annotation.Transactional
public List<Category> getCategories() {
	Session session=sessionFactory.openSession();
	Query query = session.createQuery("from Category");
	List<Category> categories=query.list();
	session.close();
	return categories;
}
@Transactional
public Category getCatById (int catId) {
	        Session session = sessionFactory.getCurrentSession();
	        return (Category) session.get(Category.class, catId);
	    }
@Transactional
public Category validate(int catId) throws IOException
{
Category category=getCatById(catId);
return category;

}
@Transactional
public void update(Category category) {
	int categoryId = category.getId();
	// TODO Auto-generated method stub
	Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(category);
}

}
