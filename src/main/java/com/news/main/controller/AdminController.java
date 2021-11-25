package com.news.main.controller;

import com.news.main.entity.Category;
import com.news.main.service.CategoryService;
import com.news.main.service.NewsService;
import com.news.main.service.TagService;
import com.news.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private UserService userService;

    //Category

    @RequestMapping(value = "/category-list", method = RequestMethod.GET)
    public String getCategoryList(Model model) {

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);


        return "category-list";
    }

    @RequestMapping(value = "/category-delete/{id}", method = RequestMethod.GET)
    public String getCategoryDelete(@PathVariable ("id") int id) {

        categoryService.deleteCategory(id);

        return "redirect:/admin/category-list";
    }

    @RequestMapping(value = "/category-form", method = RequestMethod.GET)
    public String getCategoryForm(Model model) {

        Category category = new Category();

        model.addAttribute("category", category);

        return "/category-form";
    }

    @RequestMapping(value = "/category-save", method = RequestMethod.POST)
    public String getCategorySave(@ModelAttribute Category category){


        categoryService.addCategory(category);

        return "redirect:/admin/category-list";

    }

}
