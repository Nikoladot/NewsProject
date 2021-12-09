package com.news.main.controller;

import com.news.main.dto.UserRegistrationDto;
import com.news.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationDto registrationDto) {

        userService.save(registrationDto);

        return "redirect:/registration?success";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {

        model.addAttribute("user", new UserRegistrationDto());

        return "registration-form";
    }
}
