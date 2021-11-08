package com.news.main.controller;

import java.util.ArrayList;
import java.util.List;

import com.news.main.entity.Tag;
import com.news.main.repository.CategoryRepository;
import com.news.main.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.main.entity.Category;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	

	@Autowired
	private TagService tagService;
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

	//Tag Controller

	@RequestMapping(value = "/tags")
	public List<Tag> getAllTags(){

		return  tagService.getTags();
	}



}
