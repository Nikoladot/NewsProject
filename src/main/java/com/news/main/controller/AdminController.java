package com.news.main.controller;

import com.news.main.entity.Category;
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



    @RequestMapping(value = "/category-update", method = RequestMethod.GET)
    public String getCategoryUpdate(@RequestParam("id") int id, Model model) {

        System.out.println("update metoda");
        Category category = categoryService.getCategoryById(id);

        model.addAttribute("category", category);

        return "category-form";

    }
    @RequestMapping(value = "/category-save", method = RequestMethod.POST)
    public String getCategorySave(@ModelAttribute Category category){
        System.out.println("save metoda");

        categoryService.addCategory(category);

        return "redirect:/admin/category-list";

    }

    //tags
    @RequestMapping(value = "/tag-list", method = RequestMethod.GET)
    public String getTagList(Model model) {

        List<Tag> tags = tagService.getAllTags();
        model.addAttribute("tags", tags);


        return "tag-list";
    }

    @RequestMapping(value = "/tag-delete/{id}", method = RequestMethod.GET)
    public String getTagDelete(@PathVariable ("id") int id) {

        tagService.deleteTag(id);

        return "redirect:/admin/tag-list";
    }

    @RequestMapping(value = "/tag-form", method = RequestMethod.GET)
    public String getTagsForm(Model model) {

        Tag tag = new Tag();

        model.addAttribute("tag", tag);

        return "/tag-form";
    }



    @RequestMapping(value = "/tag-update", method = RequestMethod.GET)
    public String getTagUpdate(@RequestParam("id") int id, Model model) {

        System.out.println("update metoda");
        Tag tag = tagService.getTagById(id);

        model.addAttribute("tag", tag);

        return "tag-form";

    }
    @RequestMapping(value = "/tag-save", method = RequestMethod.POST)
    public String getTagSave(@ModelAttribute Tag tag){
        System.out.println("save metoda");

        tagService.addTag(tag);

        return "redirect:/admin/tag-list";

    }

    //Users
    @RequestMapping(value = "/user-list", method = RequestMethod.GET)
    public String getUserList(Model model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);


        return "user-list";
    }

    @RequestMapping(value = "/user-delete/{id}", method = RequestMethod.GET)
    public String getUserDelete(@PathVariable ("id") int id) {

        userService.deleteUser(id);

        return "redirect:/admin/user-list";
    }



    }


