package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Author;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.models.BookImage;
import com.bookpublisher.bookpublisher.models.BookReview;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 5/15/18.
 */
@Controller
public class PublishBookController {
    private static String UPLOADED_FOLDER = "uploads/";
    @Autowired
    BookRepository bookRepository;
    Book tempBook;

    @RequestMapping(value = "/saveBook")
    public ModelAndView showSaveNewBookPage(@ModelAttribute Book book) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addBook");
        modelAndView.addObject("book", book);
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public ModelAndView showSaveBookPage(@ModelAttribute Book book, @ModelAttribute("numberOfAuthor") int rows,
                                         @RequestParam("imageFile") MultipartFile imageFile,
                                         @RequestParam("previewImageFile") MultipartFile previewImageFile) {

        book.setBookImage(new BookImage(book.getIsbn()+imageFile.getOriginalFilename(), book.getIsbn()+previewImageFile.getOriginalFilename()));
        tempBook = book;

        try {
            // Get the file and save it somewhere
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + book.getIsbn() + imageFile.getOriginalFilename());
            Files.write(path, bytes);

            bytes = previewImageFile.getBytes();
            Path path2 = Paths.get(UPLOADED_FOLDER + book.getIsbn() + previewImageFile.getOriginalFilename());
            Files.write(path2, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addAuthors");
        modelAndView.addObject("rows",rows-1);
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }


    @RequestMapping(value = "/saveAuthors", method = RequestMethod.POST)
    public ModelAndView saveAuthors(@ModelAttribute Book book) {
        ModelAndView modelAndView = new ModelAndView();
        tempBook.setAuthors(book.getAuthors());
        System.out.println(tempBook);
        bookRepository.save(tempBook);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
