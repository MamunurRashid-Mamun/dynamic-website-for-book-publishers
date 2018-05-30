package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam("searchValue") String searchValue) {
        ModelAndView modelAndView = new ModelAndView();

        List<Book> books = bookRepository.findAllByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(searchValue,searchValue);
        List<Book> booksByAuthorName = bookRepository.findByAuthorName("%"+searchValue+"%");
        if (!books.isEmpty()) {
            modelAndView.addObject("books",books);
        } else if (!booksByAuthorName.isEmpty()){
            modelAndView.addObject("books",booksByAuthorName);
        } else {
            modelAndView.addObject("bookNotFoundMessage", "No Book Found of term '" + searchValue + "'");
        }




        List<String> categories = bookRepository.findDistinctCategory();
        modelAndView.addObject("categories",categories);

        modelAndView.addObject("searchValue", searchValue);

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
