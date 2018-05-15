package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.models.Author;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.models.BookReview;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hp on 5/15/18.
 */
@Controller
public class PublishBookController {
    @Autowired
    BookRepository bookRepository;
    @RequestMapping("/save")
    public void saveBook() {
        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author("Momin","momin@gmail.com","Student of MBSTU"));
        authors.add(new Author("Mamun","mamun@gmail.com","Student of MBSTU"));
        List<BookReview> reviews = new ArrayList<BookReview>();
        reviews.add(new BookReview("Best book ever"));
        reviews.add(new BookReview("Medium level book"));
        Book book = new Book("123456","Java Book","Introduction to java","First",200,"Programming",8,authors,reviews);
        bookRepository.save(book);
        bookRepository.flush();
    }



}
