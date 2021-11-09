package com.news.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.main.entity.Category;
import com.news.main.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	//METHOD GET ALL CATEGORIES
	public List<Category> getCategories(){
		
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll()
		.forEach(categories::add);
		return categories;
		
	}
	
	//METHOD GET ONE CATEGORY BY ID
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).get();
	}
	
	//METHOD ADD NEW CATEGORY
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	//METHOD DELETE CATEGORY
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
	
	//METHOD UPDATE CATEGORY
	public void updateCategory(Category category, int id) {
		categoryRepository.save(category);
	}
	
	
}
