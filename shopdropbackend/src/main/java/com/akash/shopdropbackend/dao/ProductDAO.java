package com.akash.shopdropbackend.dao;

import java.util.List;

import com.akash.shopdropbackend.dto.Product;
import com.akash.shopdropbackend.dto.Product;

public interface ProductDAO  {

//	Method to CRUD the products
	public List<Product> list();

	public Product get(int id);

	public boolean add(Product Product);

	public boolean update(Product Product);

	public boolean delete(Product Product);
	
//	Business Methods
	public List<Product> listActiveProducts();
	
	public List<Product> listActiveProductsByCategory(int categoryId);

}
