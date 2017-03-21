package com.niit.ShoppingKart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingKart.Model.Category;
import com.niit.ShoppingKart.Model.Product;
import com.niit.ShoppingKart.Model.Supplier;
import com.niit.ShoppingKart.Service.CategoryService;
import com.niit.ShoppingKart.Service.ProductService;
import com.niit.ShoppingKart.Service.SupplierService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SupplierService supplierService;
	
	
	public ProductController() {
		System.out.println("INSTANTIATING PRODUCTCONTROLLER");
	}
	@RequestMapping("/product")
	public ModelAndView productpage() {
		
		ModelAndView mv = new ModelAndView("admin");
		List<Category> categoryList = categoryService.getCategories();
		List<Supplier> supplierList = supplierService.getSuppliers();
		mv.addObject("categoryList", categoryList);
		mv.addObject("supplierList", supplierList);
		mv.addObject("displayAddProduct", true);
		return mv;
		
	}
	
	@RequestMapping("/viewProduct")
	public ModelAndView productview() {
		
		ModelAndView mv = new ModelAndView("admin");
		List<Product> productList = productService.list();
		mv.addObject("productList",productList);
		mv.addObject("displayViewProduct",true);
		return mv;
	}
	
	@RequestMapping("editProduct/{pid}")
	public String editcategory(@PathVariable ("pid") int productId, Model model)
	{
		Product product = productService.get(productId);
		
		model.addAttribute("editProduct", true);
		model.addAttribute("product", product);
		return "admin";
	}
	
	@RequestMapping("editProduct")
	public String editProductPage(@ModelAttribute Product product )
	{
		productService.update(product);
		return "redirect:/viewProduct";
	}
	
	@RequestMapping("deleteProduct/{pid}")
	public String deleteProduct(@PathVariable ("pid") int pid, Model model){
	productService.delete(pid);
	/*List<category> categoryList = categoryService.getCategories();
	model.addAttribute("categoryList", categoryList);
	model.addAttribute("viewCategory", true);*/
		return "redirect:/viewProduct";
	
}
		
		

	@RequestMapping("/addProduct")
	public String addproduct(@ModelAttribute Product product, @RequestParam("productImage") MultipartFile file) {
		productService.update(product);
		FileUtil.upload("E://projectSC/ShoppingKart/src/main/webapp/WEB-INF/resources/productImages/", file, "ProductId"+product.getPid());
		return "redirect:/viewProduct";
	}


}
