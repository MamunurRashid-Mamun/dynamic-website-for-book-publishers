package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Author;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.repositories.AuthorRepository;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthorDetailsController {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/authorDetails")
    public ModelAndView showAuthorDetails(@RequestParam("authorId") long authorId) {
        ModelAndView modelAndView = new ModelAndView();

        Author author = authorRepository.findById(authorId);
        modelAndView.addObject("author", author);

        List<Book> books = bookRepository.findByAuthorName(author.getName());
        modelAndView.addObject("books",books);

        modelAndView.setViewName("authorDetails");
        return modelAndView;
    }
}
