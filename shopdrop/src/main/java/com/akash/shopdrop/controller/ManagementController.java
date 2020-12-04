package com.akash.shopdrop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.akash.shopdropbackend.dao.CategoryDAO;
import com.akash.shopdropbackend.dto.Category;
import com.akash.shopdropbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value="/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("pageTitle","Manage Products");
		mv.addObject("userClickManageProducts",true);
		
		Product newProduct= new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		mv.addObject("product", newProduct);
		
		return mv;
		
	}
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() {
		return categoryDAO.listCategories();
	}
	
	
}
