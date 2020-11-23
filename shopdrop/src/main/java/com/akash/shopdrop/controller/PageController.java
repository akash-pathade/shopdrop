package com.akash.shopdrop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.akash.shopdropbackend.dao.CategoryDAO;
import com.akash.shopdropbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categories", categoryDAO.listCategories());
		mv.addObject("pageTitle", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("pageTitle", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("pageTitle", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// Request Mapping for showing all products
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categories", categoryDAO.listCategories());
		mv.addObject("pageTitle", "All Products");
		mv.addObject("userClickAllProject", true);
		return mv;
	}

	// Request Mapping for showing category based products
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCatgeoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDAO to fetch a single category
		Category category = categoryDAO.get(id);
		
		mv.addObject("categories", categoryDAO.listCategories());
		
		//Passing single Category Object
		mv.addObject("category", category);
		
		mv.addObject("pageTitle", category.getName());
		mv.addObject("userClickCategoryProject", true);
		return mv;
	}

}
