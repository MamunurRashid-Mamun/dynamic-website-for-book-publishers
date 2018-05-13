package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    private String isbn;
    private String title;
    @Column(length = 1000)
    private String description;
    private String edition;
    private int price;
    private String category;
    private int rating;
    @ManyToMany
    private List<Author> authors;
    @OneToMany
    private List<BookReview> reviews;

    public Book() {
    }

    public Book(String isbn,
                String title,
                String description,
                String edition,
                int price,
                String category,
                int rating,
                List<Author> authors,
                List<BookReview> reviews) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.price = price;
        this.category = category;
        this.rating = rating;
        this.authors = authors;
        this.reviews = reviews;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<BookReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<BookReview> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", authors=" + authors +
                ", reviews=" + reviews +
                '}';
    }
}
