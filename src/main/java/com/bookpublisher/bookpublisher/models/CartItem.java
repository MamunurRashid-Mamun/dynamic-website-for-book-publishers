package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartItemId;
    private int quantity;
    private double netPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "isbn")
    private Book book;

    public CartItem() {
    }

    public CartItem(int quantity, Book book) {
        this.quantity = quantity;
        this.netPrice = quantity * book.getPrice();
        this.book = book;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.netPrice = book.getPrice() * quantity;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", quantity=" + quantity +
                ", netPrice=" + netPrice +
                ", book=" + book +
                '}';
    }
}
