package com.goup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.goup.dao.CategoryDao;
import com.goup.domain.Category;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categorydao;
	
	public List<Category> getCategories(){
		return categorydao.getCategories();
	}
	

}