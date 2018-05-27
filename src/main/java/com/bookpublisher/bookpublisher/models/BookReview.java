package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;

@Entity
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private int id;
    private String reviewer;
    private String review;

    public BookReview() {
    }

    public BookReview(String reviewer, String review) {
        this.reviewer = reviewer;
        this.review = review;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
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
                ", reviewer='" + reviewer + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
