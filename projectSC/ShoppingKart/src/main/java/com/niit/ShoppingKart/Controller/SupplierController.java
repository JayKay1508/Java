package com.niit.ShoppingKart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingKart.Model.Supplier;
import com.niit.ShoppingKart.Service.SupplierService;

@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	public SupplierController() {
		System.out.println("INSTANTIATING SUPPLIERCONTROLLER");
	}
	
	@RequestMapping("/supplier")
	public ModelAndView addSupplier() {
ModelAndView mv = new ModelAndView("admin");
mv.addObject("displayAddSupplier", true);
		return mv;
	}
	
	@RequestMapping("/newSupplier")
	public String newSupplier(@ModelAttribute Supplier supplier){
		supplierService.update(supplier);
		return "redirect:/viewSupplier";
	}
	
	@RequestMapping("editSupplier/{id}")
	public String editsupplier(@PathVariable ("id") int id, Model model)
	{
		
		Supplier supplier = supplierService.get(id);
		
		model.addAttribute("editSupplier", true);
		model.addAttribute("Supplier", supplier);
		return "admin";
	
	}
	@RequestMapping("editSupplier")
	public String editSupplierPage(@ModelAttribute("Supplier") Supplier supplier )
	{
		System.out.println(supplier.getId());
		supplierService.update(supplier);
		return "redirect:/viewSupplier";
		
		
	}
	@RequestMapping("/viewSupplier")
	public ModelAndView viewSupplier(){
		ModelAndView mv = new ModelAndView("admin");
		List<Supplier> supplierList = supplierService.getSuppliers();
		mv.addObject("displayViewSupplier", true);
		mv.addObject("supplierList", supplierList);
		return mv;
	}
	@RequestMapping("deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable ("id") int supplierId, Model model){
	supplierService.delete(supplierId);
	/*List<category> categoryList = categoryService.getCategories();
	model.addAttribute("categoryList", categoryList);
	model.addAttribute("viewCategory", true);*/
		return "redirect:/viewSupplier";
	
}



}
