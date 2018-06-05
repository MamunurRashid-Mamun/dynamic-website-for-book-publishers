package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    private String orderDate;
    private String name;
    private String phone;
    private String alternativePhone;
    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_cart_items", joinColumns = { @JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "cart_item_id") })
    private List<CartItem> cartItems;

    public Customer() {
    }

    public Customer(String name, String phone, String alternativePhone, String address) {
        this.name = name;
        this.phone = phone;
        this.alternativePhone = alternativePhone;
        this.address = address;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternativePhone() {
        return alternativePhone;
    }

    public void setAlternativePhone(String alternativePhone) {
        this.alternativePhone = alternativePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", orderDate='" + orderDate + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", alternativePhone='" + alternativePhone + '\'' +
                ", address='" + address + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }
}
