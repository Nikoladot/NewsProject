package com.news.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.main.entity.Category;
import com.news.main.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
public class TestController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/")
	public List<Category> getAllCategories() {
		
		
		return categoryService.getCategories();
	}

}
