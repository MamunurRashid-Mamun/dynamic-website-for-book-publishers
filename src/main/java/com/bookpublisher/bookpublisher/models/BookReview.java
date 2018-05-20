package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;

@Entity
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private int id;
//    @ManyToOne
//    @Column(name = "review_isbn")
//    private String isbn;
    private String review;

    public BookReview() {
    }

    public BookReview(String review) {
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", review='" + review + '\'' +
                '}';
    }
}
