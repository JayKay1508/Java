package com.niit.ShoppingKart.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ShoppingKart.Model.Authorities;
import com.niit.ShoppingKart.Model.BillingAddress;
import com.niit.ShoppingKart.Model.Cart;
import com.niit.ShoppingKart.Model.Customer;
import com.niit.ShoppingKart.Model.ShippingAddress;
import com.niit.ShoppingKart.Service.AuthoritiesService;
import com.niit.ShoppingKart.Service.BillingAddressService;
import com.niit.ShoppingKart.Service.CustomerService;
import com.niit.ShoppingKart.Service.ShippingAddressService;

@Controller
public class CustomerController {

	@Autowired
	private Authorities authorities;

	@Autowired
	private AuthoritiesService authoritiesService;

	@Autowired
	private CustomerService customerService;


	@Autowired
	private ShippingAddressService shippingAddressService;

	

	@Autowired
	private BillingAddressService billingAddressService;

	public CustomerController() {
		System.out.println("INSTANTIATING CUSTOMERCONTROLLER");
	}

	@RequestMapping("/registerCustomer")
	public String registerpage() {

		return "registerCustomer";
	}
	

	@RequestMapping("/newUsers")
	public String newUsers(@ModelAttribute Customer customer, @ModelAttribute ShippingAddress shippingAddress,
			@ModelAttribute BillingAddress billingAddress, Model model) {

		String email=customer.getEmail();
		
		
		if(customerService.CustomerAlreadyExist(email, true)){
			model.addAttribute("message", "Email is already registered");
			
		}
		else{
		
		customer.setEnabled(true);

		authorities.setRole("ROLE_USER");
		authorities.setUsername(customer.getUsername());

		customer.setAuthorities(authorities);
		authorities.setCustomer(customer);

		customerService.update(customer);
		authoritiesService.saveOrUpdate(authorities);

		shippingAddress.setId(customer.getId());
		billingAddress.setId(customer.getId());

		shippingAddressService.update(shippingAddress);
		billingAddressService.update(billingAddress);
		model.addAttribute("message", "Your Successfully registered");
	
		}
		return "login";
		
	}

}
