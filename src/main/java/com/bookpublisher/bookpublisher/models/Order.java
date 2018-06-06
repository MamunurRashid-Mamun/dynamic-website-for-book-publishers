package com.bookpublisher.bookpublisher.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cusotmer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderNo;
    private String status;
    private String orderDate;
    private String customerName;
    private String customerPhone;
    private String customerAternativePhone;
    private String customerAddress;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "customer_order_cart_items", joinColumns = { @JoinColumn(name = "order_no") }, inverseJoinColumns = { @JoinColumn(name = "cart_item_id") })
    private List<CartItem> cartItems;

    public Order() {

    }

    public Order(String status, String orderDate, String customerName, String customerPhone, String customerAternativePhone, String customerAddress, List<CartItem> cartItems) {
        this.status = status;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAternativePhone = customerAternativePhone;
        this.customerAddress = customerAddress;
        this.cartItems = cartItems;
    }

    public long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(long orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAternativePhone() {
        return customerAternativePhone;
    }

    public void setCustomerAternativePhone(String customerAternativePhone) {
        this.customerAternativePhone = customerAternativePhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", status='" + status + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAternativePhone='" + customerAternativePhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }
}
