package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage","");
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
