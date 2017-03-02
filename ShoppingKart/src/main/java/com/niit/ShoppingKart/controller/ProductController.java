package com.niit.ShoppingKart.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ShoppingKart.model.Product;
import com.niit.ShoppingKart.service.CategoryService;
import com.niit.ShoppingKart.service.ProductService;

@Controller
public class ProductController {
	@Autowired
private ProductService productService;
@Autowired
private CategoryService categoryService;	
	Logger logger=Logger.getLogger(ProductController.class);
public ProductController(){
	System.out.println("CREATING INSTANCE FOR PRODUCTCONTROLLER");
}

//http://localhost:8080/project1/admin/product/productform
@RequestMapping("/admin/product/productform")
public String getProductForm(Model model){
	//Product product = new Product();
	model.addAttribute("product",new Product());
	model.addAttribute("categories",categoryService.getCategories());
	return "productform";
}

/*@RequestMapping("/admin/product/addProduct")
public String saveProduct(@Valid  @ModelAttribute(value="product") Product product,BindingResult result, Model model){
	model.addAttribute("categories", categoryService.getCategories());
	logger.debug("=========");
	if(result.hasErrors())
		return "productform";
	productService.saveProduct(product);
	
	MultipartFile prodImage=product.getImage();
	if(!prodImage.isEmpty()){
		Path paths=
Path.get("D:/JayKay/workspace/project1/src/main/webapp/WEB-INF/images/"+ product.getId()+".png");
	try {
		prodImage.transferTo(new File(paths.toString()));
	} catch (IllegalStateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	logger.debug("============================================");
	return "redirect:/all/product/getAllProducts";
}
*/

@RequestMapping("/all/product/getAllProducts")
public String getAllProducts(Model model){
	List<Product> products=productService.getAllProducts();
	//Assigning list of products to model attribute products
	model.addAttribute("productList",products);
	return "productlist";
}
@RequestMapping("/all/product/viewproduct/{id}")
public String viewProduct(@PathVariable int id,Model model){
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
return "viewproduct";
}

@RequestMapping("/admin/product/deleteproduct/{id}")
public String deleteProduct(@PathVariable int id){
	productService.deleteProduct(id);
	return "redirect:/all/product/getAllProducts";
}


/**
 *    to display the form to edit product details
 */
@RequestMapping("/admin/product/editform/{id}")
public String editProductForm(@PathVariable int id,Model model){
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
	model.addAttribute("categories",categoryService.getCategories());
	return "editproductform";
}
@RequestMapping("/admin/product/editProduct")
public String editProductDetails(@Valid @ModelAttribute("product") Product product,
		BindingResult result){
	if(result.hasErrors())
		return "productform";
	productService.updateProduct(product);
	return "redirect:/all/product/getAllProducts";
}
@RequestMapping("/all/product/productsByCategory")
public String getProductsByCategory(@RequestParam(name="searchCondition") String searchCondition,
		Model model){
	List<Product> products=productService.getAllProducts();
	//Assigning list of products to model attribute products
	model.addAttribute("productList",products);
	model.addAttribute("searchCondition",searchCondition);
	return "productlist";
}

}