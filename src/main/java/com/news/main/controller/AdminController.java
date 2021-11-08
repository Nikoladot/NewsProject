package com.news.main.controller;

import java.util.List;
import com.news.main.entity.Tag;
import com.news.main.service.CategoryService;
import com.news.main.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.main.entity.Category;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	

	@Autowired
	private TagService tagService;
	@Autowired
	private CategoryService categoryService;
	
	//_______________________ CATEGORY METHODS __________________________________________
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categoryService.getCategories();
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public Category getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST )
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);	
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
	public void updateCategory(@RequestBody Category category, @PathVariable int id) {
		categoryService.updateCategory(category, id);
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
		
	}
	
	
	//_____________________________ TAG METHODS _________________________________________


	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public List<Tag> getAllTags(){

		return  tagService.getAllTags();
	}
	
	@RequestMapping(value = "/tags/{id}", method = RequestMethod.GET)
	public Tag getTagById(@PathVariable int id) {
		
		return tagService.getTagById(id);
	}
	
	@RequestMapping(value = "/tags", method = RequestMethod.POST)
	public void addTag(@RequestBody Tag tag) {
		tagService.addTag(tag);
	}
	
	@RequestMapping(value = "/tags/{id}", method = RequestMethod.PUT)
	public void updateTag(@RequestBody Tag tag, @PathVariable int id) {
		tagService.updateTag(tag, id);
	}
	
	@RequestMapping(value = "/tags/{id}", method = RequestMethod.DELETE)
	public void deleteTag(@PathVariable int id) {
		tagService.deleteTag(id);
	}
	
	



}
