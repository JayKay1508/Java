package com.niit.ShoppingKart.Controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingKart.Model.Authorities;
import com.niit.ShoppingKart.Model.Product;
import com.niit.ShoppingKart.Service.AuthoritiesService;
import com.niit.ShoppingKart.Service.ProductService;


@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AuthoritiesService authoritiesService;

	
	public HomeController(){
		System.out.println("INSTANTIATING HOMECONTROLLER");
	}
	
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("/")
	public ModelAndView productview() {
		
		ModelAndView mv = new ModelAndView("home");
		List<Product> productList = productService.list();
		mv.addObject("productList",productList);
		return mv;
	}
	
	/*@RequestMapping("/")
	public String HomePage(Model model){
		List<Product> productList = productService.getProducts();
		model.addAttribute("productList", productList);
		return "home";
			}*/
	/*@RequestMapping("/")
	public String getindex(Model model){
		List<Product> productList = productService.getProducts();
		model.addAttribute("productList", productList);
		return "home";
	}*/
	
	@RequestMapping("/aboutUs")
	public String aboutUs(){
		return "aboutUs";
	}
	
	
		
		@RequestMapping("/success")
		public String spage(){
			return "success";
		}
		@RequestMapping("/sidebar")
		public String sidepage(){
			return "sidebar";
		}
		@RequestMapping("/loginpage")
		public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error, 
				@RequestParam(value = "logout", required = false) String logout, Model model){
			ModelAndView mv = new ModelAndView("login");
			
			if(error != null) {
				model.addAttribute("error", "Username or Password Incorrect");
				}
			
			if(logout != null) {
				model.addAttribute("logout", "Logged out Successfully");
				}
			
			mv.addObject("isLoginClicked", true);
			return mv;
		}
			
		@RequestMapping("/logout")
		public ModelAndView logoutPage(){
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("isLoggedOutClicked", true);
			mv.addObject("logout", "Your Are Successfully Logged Out");
			return mv;
		}
		
		@RequestMapping("/afterlogin")
		public String afterLogin(Principal p, Model model, @RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout) {

			String username = p.getName();

			Authorities authorities = authoritiesService.get(username);
			
			String role = authorities.getRole();
			
			if(role.equals("ROLE_USER")){
				model.addAttribute("loginUser", true);
				List<Product> productList = productService.list();
				model.addAttribute("productList",productList);
				return "users";
			}
			else if(role.equals("ROLE_ADMIN")){
				
				model.addAttribute("loginAdmin", true);
				return "admin";
			}
			
			else{
				return "login";
			}
			

		}

	
}
	
