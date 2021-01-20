package com.akash.shopdrop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akash.shopdrop.util.FileUploadUtility;
import com.akash.shopdropbackend.dao.CategoryDAO;
import com.akash.shopdropbackend.dao.ProductDAO;
import com.akash.shopdropbackend.dto.Category;
import com.akash.shopdropbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(ManagementController.class);

	@GetMapping(value = "/products")
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("pageTitle", "Manage Products");
		mv.addObject("userClickManageProducts", true);

		Product newProduct = new Product();
		newProduct.setSupplierId(1);
		newProduct.setActive(true);
		mv.addObject("product", newProduct);

		if (operation != null && operation.equals("productSaved")) {

			mv.addObject("message", "Product saved successfully");

		}

		return mv;

	}

	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.listCategories();
	}

	// Save product (Using ModelAttribute to get the product object from spring
	// form)
	@PostMapping(value = "/products")
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model mv, HttpServletRequest request) {

		// Check if any errors in validation, if yes then add error message
		if (results.hasErrors()) {
			mv.addAttribute("pageTitle", "Manage Products");
			mv.addAttribute("userClickManageProducts", true);
			mv.addAttribute("message", "Please enter valid details!!");
			return "page";
		}

		LOGGER.info("saving..." + mProduct);
		// Saving the product
		productDAO.add(mProduct);

		// This is to upload the recieved file (Product Image)
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=productSaved";

	}

}
