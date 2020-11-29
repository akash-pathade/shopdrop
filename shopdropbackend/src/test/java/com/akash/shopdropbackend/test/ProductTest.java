package com.akash.shopdropbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akash.shopdropbackend.dao.ProductDAO;
import com.akash.shopdropbackend.dto.Product;

public class ProductTest {
	
	private Product product;
	
	private static ProductDAO productDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.akash.shopdropbackend");
		context.refresh();
		productDAO= (ProductDAO) context.getBean("productDAO");
		
	}
	
//	method to test crud operations
	@Test
	public void testCRUDProduct() {
		
//		Creating a product
		product = new Product();
		product.setBrand("OPPO");
		product.setName("Oppo F11");
		product.setDescription("Best in class camera");
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
//		Testing add()
		assertEquals("Successfully added product",true,productDAO.add(product));
		
//		Testing get()
		product= productDAO.get(6);
		
//		Testing update()
		product.setDescription("Best in class service");
		assertEquals("Successfully got and updated product",true,productDAO.update(product));
		
//		Testing delete
		assertEquals("Successfully deleted product",true,productDAO.delete(product));
		
//		list all products
		assertEquals("Listed ALL products",9,productDAO.list().size());
		
//		list
		assertEquals("Listed Active products",8,productDAO.listActiveProducts().size());
		
				
	}

}
