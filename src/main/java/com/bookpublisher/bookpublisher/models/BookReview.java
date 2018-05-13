package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;

@Entity
public class BookReview {
    @Id
    private int isbn;
    private String review;

    public BookReview() {
    }

    public BookReview(int isbn, String review) {
        this.isbn = isbn;
        this.review = review;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
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
                "isbn=" + isbn +
                ", review='" + review + '\'' +
                '}';
    }
}
