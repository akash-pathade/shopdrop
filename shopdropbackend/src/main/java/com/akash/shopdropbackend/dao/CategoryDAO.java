package com.akash.shopdropbackend.dao;

import java.util.List;

import com.akash.shopdropbackend.dto.Category;

public interface CategoryDAO {

//	Method to list all the categories
	public List<Category> listCategories();

//  Method to return a category based on id
	public Category get(int id);

//    Method to add a category to DB
	public boolean add(Category category);

//  Method to update a category to DB
	public boolean update(Category category);

//Method to delete a category to DB
	public boolean delete(Category category);
}
