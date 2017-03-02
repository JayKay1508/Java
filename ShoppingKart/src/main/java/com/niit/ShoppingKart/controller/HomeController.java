package com.niit.ShoppingKart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ShoppingKart.service.CategoryService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categoryService;
	public HomeController(){
		System.out.println("INSTANTIATING HOMECONTROLLER");
	}
@RequestMapping("/home")	
public String home(HttpSession session){
	session.setAttribute("categories", categoryService.getCategories());
	return "home";
}
@RequestMapping("/aboutUs")
public String aboutUs(){
	return "aboutUs";
}
}
