package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
@SessionAttributes({"cartItems","userName"})
public class HomeController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public ModelAndView showHome(HttpSession session, Principal principal){
        ModelAndView modelAndView = new ModelAndView();

        List<Book> books = bookRepository.findAll();
        modelAndView.addObject("books",books);
        if (principal != null) {
            User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
            session.setAttribute("cartItems",user.getCartItems());
            session.setAttribute("userName",user.getUserName());
        }
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
