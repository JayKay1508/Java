package com.niit.ShoppingKart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ShoppingKart.model.Customer;
import com.niit.ShoppingKart.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
private CustomerService customerService;	
	
@RequestMapping("/all/registrationForm")
public String getRegistrationForm(Model model){
	model.addAttribute("customer",new Customer());
	return "registerCustomer";
}
@RequestMapping("/all/registerCustomer")
public String registerCustomer(@Valid @ModelAttribute(value="customer") Customer customer, BindingResult result, Model model){
	if(result.hasErrors())
		return "registerCustomer";
	try{
	customerService.saveCustomer(customer);
	}catch(Exception e){
		model.addAttribute("duplicateUsername","Username already exists. Please enter different username");
		System.out.println("Exception is" + e.getMessage());
		return "registerCustomer";
	}
	return "home";
}

}