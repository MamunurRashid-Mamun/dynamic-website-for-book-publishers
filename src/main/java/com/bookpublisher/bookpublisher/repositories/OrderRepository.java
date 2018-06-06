package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM CUSTOMER_ORDER_CART_ITEMS WHERE ORDER_NO = ?1", nativeQuery = true)
    Integer deleteByOrderNoFromCustomerCartItem(long cartItemId);
}
