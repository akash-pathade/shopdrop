package com.akash.shopdropbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akash.shopdropbackend.dao.CategoryDAO;
import com.akash.shopdropbackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.akash.shopdropbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

//	  @Test public void testAddCategory() { category = new
//	  Category("Mobile","Mobiles from Top Brands","CAT_03.png");
//	  
//	  assertEquals("Succesfully added category "+category.getName(), true,
//	  categoryDAO.add(category));
//	  
//	  }

//	  @Test 
//	  public void testGetCategory() { category = categoryDAO.get(1);

//	  assertEquals("Succesfully fetched single category "+category.getName(),
//	  "Mobile", categoryDAO.get(1).getName());
//	  
//	  }

//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(6);
//		category.setName("Television");
//
//		assertEquals("Succesfully updated category " + category.getName(), true, categoryDAO.update(category));
//
//	}

//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(6);
//		assertEquals("Succesfully updated category " + category.getName(), true, categoryDAO.delete(category));
//
//	}

//	@Test
//	public void testListCategories() {
//	
//		assertEquals("Succesfully fetched list of categories" , 1, categoryDAO.listCategories().size());
//
//	}

	@Test
	public void testCrudCategory() {
		
		//Testing add single category
		category = new Category("Mobile", "Mobiles from Top Brands", "CAT_01.png");
		assertEquals("Succesfully added category " + category.getName(), true, categoryDAO.add(category));
		
		category = new Category("TV", "TV from Top Brands", "CAT_02.png");
		assertEquals("Succesfully added category " + category.getName(), true, categoryDAO.add(category));
		
//		Fetching and Updatig category
		category = categoryDAO.get(2);
		category.setName("Television");
		assertEquals("Succesfully updated category " + category.getName(), true, categoryDAO.update(category));
		
//		Delete the category
		assertEquals("Succesfully deleted (deactivated) category " + category.getName(), true, categoryDAO.delete(category));
		
//		List all categories
		assertEquals("Succesfully fetched list of categories" , 1, categoryDAO.listCategories().size());

	}

}
