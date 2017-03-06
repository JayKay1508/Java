package com.niit.ShoppingKart.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ShoppingKart.Model.Customer;
import com.niit.ShoppingKart.Service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	public CustomerController() {
		System.out.println("INSTANTIATING CUSTOMERCONTROLLER");
	}

	@RequestMapping("/registerCustomer")
	public String registerpage() {

		return "registerCustomer";
	}
	@RequestMapping("/newUsers")
	public String customer(@ModelAttribute Customer customer){
		customerService.update(customer);
		return "home";
	}

	
}
