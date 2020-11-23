package com.akash.shopdropbackend.dao;

import java.util.ArrayList;
import java.util.List;

import com.akash.shopdropbackend.dto.Category;

public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	static {
		categories.add(new Category(1,"Mobile","Desc Mob","CAT_1.png",true));
		categories.add(new Category(2,"Laptop","Desc Laptop","CAT_2.png",true));
		categories.add(new Category(3,"TV","Desc TV","CAT_3.png",true));
	}
	@Override
	public List<Category> listCategories() {
		
		return categories;
	}

}
