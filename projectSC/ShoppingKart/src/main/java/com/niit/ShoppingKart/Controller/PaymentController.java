package com.niit.ShoppingKart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ShoppingKart.Model.BillingAddress;
import com.niit.ShoppingKart.Model.ShippingAddress;
import com.niit.ShoppingKart.Service.BillingAddressService;
import com.niit.ShoppingKart.Service.ShippingAddressService;

@Controller
public class PaymentController {
	@Autowired
	private BillingAddressService billingAddressService;
	@Autowired
	private ShippingAddressService shippingAddressService;
	public PaymentController(){
		System.out.println("INSTANTIATING PAYMENTCONTROLLER");
	}
	@RequestMapping("/newbillingAddress")	
	public String paymentBilling(){
		
		return "billingAddress";
	}
	@RequestMapping("/billingAddress")
	public String billingAddress(@ModelAttribute BillingAddress billingAddress){
		billingAddressService.update(billingAddress);
		return "home";
	}
	
	@RequestMapping("/newshippingAddress")	
	public String paymentShipping(){
		
		return "shippingAddress";
	}
	@RequestMapping("/shippingAddress")
	public String shippingAddress(@ModelAttribute ShippingAddress shippingAddress){
		shippingAddressService.update(shippingAddress);
		return "home";
}
}
