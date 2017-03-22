package com.niit.ShoppingKart.Controller;

import java.security.Principal;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.ShoppingKart.Model.Cart;
import com.niit.ShoppingKart.Model.Customer;
import com.niit.ShoppingKart.Model.Product;
import com.niit.ShoppingKart.Service.CartService;
import com.niit.ShoppingKart.Service.CustomerService;
import com.niit.ShoppingKart.Service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private Cart cart;
	@Autowired
	private CartService cartService;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/myCart")
	public String Cart(Principal p,  Model model){
		String username = p.getName();
		List<Cart> cartList = cartService.list(username);
		model.addAttribute("cartList", cartList);
		return "myCart";
	}
	
	@RequestMapping("productDetails/{id}")
	public String viewProductDetails(@PathVariable ("id") int productId, Model model) {
		Product product = productService.get(productId);
		model.addAttribute("loginUser", true);
		model.addAttribute("productDetails", true);
		model.addAttribute("product", product);
		return "users";	  
	 }
	@RequestMapping("deletecart/{cartId}")
	public String deletecart(@PathVariable ("cartId") int cartId){
	
		Cart crt=cartService.get(cartId);
		Product product=productService.get(crt.getProductId());
		int qty=product.getQuantity()+crt.getQuantity();
		
		product.setQuantity(qty);
		productService.update(product);
		cartService.delete(cartId);
		return "redirect:/myCart";
	}
	
	@RequestMapping(value="/addtocart/{pid}" , method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addtocart(@PathVariable("pid") int pid,Principal pr, Model model){
		
		String username = pr.getName();
		customer = customerService.get(username);
		int userId = customer.getId();
		Product p = productService.get(pid);
		Cart crt = cartService.getByUserandProduct(userId, pid);
		
		if(p.getQuantity() > 1 ){
			
			Random t = new Random();
			int day = 2 + t.nextInt(7);
			
			if(cartService.itemAlreadyExist(userId, pid, true)){
				
				int qty = crt.getQuantity() + 1;
				cart.setQuantity(qty);
				cart.setTotal(qty * p.getPrice());
				cartService.saveOrUpdate(cart);
				
			}else{
				
			
			
			cart.setUserId(customer.getId());
			cart.setUserName(username);
			cart.setStatus("N");
			cart.setDays(day);
			cart.setProductName(p.getName());
			cart.setProductId(p.getPid());
			cart.setPrice(p.getPrice());
			cart.setQuantity(1);
			cart.setTotal(p.getPrice()*cart.getQuantity());
			System.out.println("inside insert cartController");
			
			cartService.saveOrUpdate(cart);
			
			
			}
			int Stock = p.getQuantity() - 1;
			p.setQuantity(Stock);
			productService.update(p);
		}
		else{
			model.addAttribute("message", "Out Of Stock");
		}
		
		
		 
	}
	@RequestMapping("/order/{user_name}")
	public String placeorder(@PathVariable("user_name") String user_name){
		
		return "redirect:/checkout?user_name"+user_name;
		
	}
	

}
