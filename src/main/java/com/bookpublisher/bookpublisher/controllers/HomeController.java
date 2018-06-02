package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView();

        List<Book> books = bookRepository.findAll();
        modelAndView.addObject("books",books);

        List<String> categories = bookRepository.findDistinctCategory();
        modelAndView.addObject("categories",categories);

        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/findByCategory")
    public ModelAndView findBookByCategory(@RequestParam("bookCategory") String bookCategory){
        ModelAndView modelAndView = new ModelAndView();

        List<Book> books = bookRepository.findAllByCategory(bookCategory);
        modelAndView.addObject("books",books);

        List<String> categories = bookRepository.findDistinctCategory();
        modelAndView.addObject("categories",categories);

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
