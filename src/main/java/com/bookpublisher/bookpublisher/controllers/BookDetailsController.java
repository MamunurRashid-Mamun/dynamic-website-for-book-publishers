package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.models.BookReview;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class BookDetailsController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/bookDetails")
    public ModelAndView showBookDetailsPage(@RequestParam("isbn") String isbn) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookRepository.findByIsbn(isbn);
        modelAndView.addObject("book", book);
        modelAndView.setViewName("bookDetails");
        return modelAndView;
    }

    @RequestMapping("/writeReview")
    public ModelAndView writeReview(@RequestParam("isbn") String isbn,
                                    @ModelAttribute("review") String review,
                                    Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookRepository.findByIsbn(isbn);
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        book.getReviews().add(new BookReview(user.getUserName(), review));
        bookRepository.save(book);
        modelAndView.addObject("book", book);
        modelAndView.setViewName("redirect:/bookDetails?isbn=" + isbn);
        return modelAndView;
    }


}
