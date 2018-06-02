package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class BookListController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/addToBookList")
    public ModelAndView addToBookList(@RequestParam("isbn") String isbn, Principal principal, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        Book book = bookRepository.findByIsbn(isbn);
        if (user.getBookList().contains(book)) {
            redirectAttributes.addFlashAttribute("errorMessage","This Book has been already added to your Booklist");
            modelAndView.setViewName("redirect:/bookDetails?isbn="+isbn);
            return modelAndView;
        }
        user.getBookList().add(book);
        userRepository.save(user);
        modelAndView.addObject("bookList",user.getBookList());
        modelAndView.setViewName("redirect:/user/myBookList");
        return modelAndView;
    }

    @RequestMapping(value = "/user/myBookList")
    public ModelAndView showMyBookList(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        modelAndView.addObject("bookList",user.getBookList());
        modelAndView.setViewName("myBookList");
        return modelAndView;
    }

    @RequestMapping(value = "/user/deleteBookFromList")
    public ModelAndView deleteBookFromList(@RequestParam("isbn") String isbn, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        user.getBookList().remove(bookRepository.findByIsbn(isbn));
        userRepository.save(user);
        modelAndView.addObject("bookList",user.getBookList());
        modelAndView.setViewName("redirect:/user/myBookList");
        return modelAndView;
    }


}
