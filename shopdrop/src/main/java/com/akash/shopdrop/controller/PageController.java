package com.akash.shopdrop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.akash.shopdrop.exception.ProductNotFoundException;
import com.akash.shopdropbackend.dao.CategoryDAO;
import com.akash.shopdropbackend.dao.ProductDAO;
import com.akash.shopdropbackend.dto.Category;
import com.akash.shopdropbackend.dto.Product;


@Controller
public class PageController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		
		logger.info("Inside index method - INFO");
		logger.debug("Inside index method - DEBUG");
		
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
		// To be coded
		mv.addObject("categories", categoryDAO.listCategories());
		mv.addObject("pageTitle", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	// Request Mapping for showing category based products
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCatgeoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = categoryDAO.get(id);

		mv.addObject("categories", categoryDAO.listCategories());

		// Passing single Category Object
		mv.addObject("category", category);

		mv.addObject("pageTitle", category.getName());
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	// Request Mapping for showing single product
	@RequestMapping(value = { "/show/{id}/product" })
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");

//		Increasing view of products
		Product product = productDAO.get(id);
		if(product==null)
			throw new ProductNotFoundException();
		
		product.setViews(product.getViews() + 1);
		productDAO.update(product);

//		passing product object
		mv.addObject("product", product);
		mv.addObject("pageTitle", product.getName());
		mv.addObject("userClickSingleProduct", true);
		return mv;
	}

}
