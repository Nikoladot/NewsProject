package com.news.main.controller;

import java.util.List;

import com.news.main.entity.Tag;
import com.news.main.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.main.entity.Category;
import com.news.main.service.CategoryService;

@RestController
@RequestMapping(value = "/api")
public class Controller {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;

	//Category Contoller
	@RequestMapping(value = "/categories")
	public List<Category> getAllCategories() {
		
		
		return categoryService.getCategories();
	}

	//Tag Controller

	@RequestMapping(value = "/tags")
	public List<Tag> getAllTags(){

		return  tagService.getTags();
	}



}
