package com.niit.ShoppingKart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingKart.Model.Category;
import com.niit.ShoppingKart.Service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	public CategoryController(){
		System.out.println("INSTANTIATING CATEGORY_CONTROLLER");
	}
	
	@RequestMapping("/category")	
	public ModelAndView categoryform(){
		
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("displayAddCategory", true);
				return mv;
	}
	
	@RequestMapping("editCategory/{id}")
	public String editcategory(@PathVariable ("id") int id, Model model)
	{
		Category category = categoryService.getCatById(id);
		model.addAttribute("editCategory", true);
		model.addAttribute("category", category);
		return "admin";
	}
	@RequestMapping("editCategory")
	public String editCategoryPage(@ModelAttribute Category category )
	{
		categoryService.update(category);
		return "redirect:/viewCategory";
		
		
	}
	@RequestMapping("/viewCategory")
	public ModelAndView viewCategory()
	{
		ModelAndView mv = new ModelAndView("admin");
	List<Category> categoryList = categoryService.getCategories();
	mv.addObject("categoryList", categoryList);
		mv.addObject("displayViewCategory", true);
		return mv;
	}

	@RequestMapping("deleteCategory/{id}")
		public String deleteCategory(@PathVariable ("id") int id, Model model){
		categoryService.delete(id);
		/*List<category> categoryList = categoryService.getCategories();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("viewCategory", true);*/
			return "redirect:/viewCategory";
		
	}

	@RequestMapping("/newCategory")
	public String category(@ModelAttribute Category category){
		categoryService.update(category);
		return "redirect:/viewCategory";
	}



}
