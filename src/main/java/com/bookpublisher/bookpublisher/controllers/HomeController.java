package com.bookpublisher.bookpublisher.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/securedData")
    public ModelAndView showSecuredData(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("securedData");
        return modelAndView;
    }
}
