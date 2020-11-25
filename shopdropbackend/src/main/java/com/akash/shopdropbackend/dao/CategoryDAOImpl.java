package com.akash.shopdropbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akash.shopdropbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
//	Getting the Session Factory Bean
	@Autowired
	SessionFactory sessionFactory;

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
	@Override
	public Category get(int id) {
		for(Category category : categories) {
			if(category.getId()==id)
				return category;
		}
		return null;
	}
	
//	Method to add a category to DB
	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
