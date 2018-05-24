package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        List<Book> books = bookRepository.findAll();
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @RequestMapping("/securedData")
    public ModelAndView showSecuredData(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("securedData");
        return modelAndView;
    }
}
