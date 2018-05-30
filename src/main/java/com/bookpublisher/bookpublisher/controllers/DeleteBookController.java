package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.security.Principal;

@Controller
public class DeleteBookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/deleteBook")
    public ModelAndView showDeleteBookPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allBook",bookRepository.findAll());
        modelAndView.setViewName("deleteBook");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteOneBook")
    public ModelAndView deleteBook(@RequestParam("isbn") String isbn) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookRepository.findByIsbn(isbn);
        File file1 = new File("uploads/"+book.getBookImage().getImageTitle());
        File file2 = new File("uploads/"+book.getBookImage().getPreviewImageTitle());
        if (file1.exists()) {
            file1.delete();
        }
        if (file2.exists()) {
            file2.delete();
        }

        bookRepository.delete(book);
        modelAndView.addObject("allBook",bookRepository.findAll());
        modelAndView.setViewName("redirect:/deleteBook");
        return modelAndView;
    }


}
