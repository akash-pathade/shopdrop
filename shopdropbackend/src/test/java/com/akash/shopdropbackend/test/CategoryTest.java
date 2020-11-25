package com.akash.shopdropbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akash.shopdropbackend.dao.CategoryDAO;
import com.akash.shopdropbackend.dto.Category;

public class CategoryTest {
	
	private static AnnotationConfigApplicationContext context ;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.akash.shopdropbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
	@Test
	public void testAddCategory() {
		category = new Category("Mobile","Smartphones from Top Brands","CAT_01.png");
		
		assertEquals("Succesfully added category "+category.getName(), true, 
				categoryDAO.add(category));
		
	}

}
