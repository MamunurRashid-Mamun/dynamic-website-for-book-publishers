package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookDetailsController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/bookDetails")
    public ModelAndView showBookDetailsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookDetails");
        return modelAndView;
    }
}
