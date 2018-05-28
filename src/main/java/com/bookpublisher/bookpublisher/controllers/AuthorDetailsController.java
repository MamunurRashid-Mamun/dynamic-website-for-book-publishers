package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Author;
import com.bookpublisher.bookpublisher.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorDetailsController {
    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping("/authorDetails")
    public ModelAndView showAuthorDetails(@RequestParam("authorId") long authorId) {
        ModelAndView modelAndView = new ModelAndView();
        Author author = authorRepository.findById(authorId);
        modelAndView.addObject("author", author);
        modelAndView.setViewName("authorDetails");
        return modelAndView;
    }
}
