package com.niit.ShoppingKart.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ShoppingKart.Model.Category;
import com.niit.ShoppingKart.Service.CategoryService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	public HomeController(){
		System.out.println("INSTANTIATING HOMECONTROLLER");
	}
@RequestMapping("/category")	
public String home(){
	
	return "category";
}
@RequestMapping("/newCategory")
public String category(@ModelAttribute Category category){
	categoryService.update(category);
	return "home";
}
}
