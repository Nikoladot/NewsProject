package com.news.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.main.entity.Category;
import com.news.main.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	//LIST OF CATEGORIES
	
	public List<Category> getCategories(){
		
		return categoryRepository.findAll();
		
	}
	
	
}
