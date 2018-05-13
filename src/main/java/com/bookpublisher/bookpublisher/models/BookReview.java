package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;

@Entity
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Book book;
    private String review;

    public BookReview() {
    }

    public BookReview(int id, Book book, String review) {
        this.id = id;
        this.book = book;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "BookReview{" +
                "id=" + id +
                ", book=" + book +
                ", review='" + review + '\'' +
                '}';
    }
}
