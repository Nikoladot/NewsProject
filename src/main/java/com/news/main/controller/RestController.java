package com.news.main.controller;

import java.util.List;
import com.news.main.entity.Tag;
import com.news.main.entity.User;
import com.news.main.service.CategoryService;
import com.news.main.service.NewsService;
import com.news.main.service.TagService;
import com.news.main.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.news.main.entity.Category;
import com.news.main.entity.News;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest")
public class RestController {
	

	@Autowired
	private TagService tagService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	
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
	
	//_____________________________ NEWS METHODS _________________________________________
	
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public List<News> getAllNews() {

		System.out.println(newsService.getAllNews());
		return newsService.getAllNews();
		
	}
	
	@RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
	public News getNewsById(@PathVariable int id) {
		return newsService.getNewsById(id);
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.POST)
	public void addNews(@RequestBody News news) {
		newsService.addNews(news);
	}
	
	@RequestMapping(value = "/news/{id}", method = RequestMethod.PUT)
	public void updateNews(@RequestBody News news, @PathVariable int id) {
		newsService.updateNews(news, id);
	}
	
	@RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
	public void deleteNews(@PathVariable int id) {
		newsService.deleteNews(id);
	}
	
	//___________________________USER METHODS___________________________________________

	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
	public User getUserByUsername(@PathVariable int id) {
		return userService.getUserByUsername(id);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user,@PathVariable String username) {
		userService.updateUser(user, username);
	}
	
	@RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id) {
		userService.delete(id);
	}
	



}
