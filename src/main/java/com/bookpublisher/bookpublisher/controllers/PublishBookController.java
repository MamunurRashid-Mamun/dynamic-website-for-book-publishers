package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Author;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.models.BookReview;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 5/15/18.
 */
@Controller
public class PublishBookController {
    @Autowired
    BookRepository bookRepository;
    int rows = 0;
//    @RequestMapping("/save")
//    public void saveBook() {
//        List<Author> authors = new ArrayList<Author>();
//        authors.add(new Author("Momin","momin@gmail.com","Student of MBSTU"));
//        authors.add(new Author("Mamun","mamun@gmail.com","Student of MBSTU"));
//        List<BookReview> reviews = new ArrayList<BookReview>();
//        reviews.add(new BookReview("Best book ever"));
//        reviews.add(new BookReview("Medium level book"));
//        Book book = new Book("123456","Java Book","Introduction to java","First",200,"Programming",8,authors,reviews);
//        bookRepository.save(book);
//        bookRepository.flush();
//    }


    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public String showSaveBookPage(@ModelAttribute Book book) {
//        newBookRepository.save(newBookClass);
//        newBookRepository.flush();
        System.out.println(book);
        rows = 0;
        return "/home";
    }

    @RequestMapping(value = "/saveBook")
    public ModelAndView showSaveNewBookPage(@ModelAttribute Book book) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addBook");
        modelAndView.addObject("book", book);
        modelAndView.addObject("rows",rows);
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @RequestMapping(value = "/increaseAuthor")
    public ModelAndView increaseAuthor(RedirectAttributes redirectAttributes, @Param("bookParam") Book book) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(rows++);
        redirectAttributes.addAttribute("book", book);
        modelAndView.setViewName("redirect:/saveBook");
        return modelAndView;
    }

}
