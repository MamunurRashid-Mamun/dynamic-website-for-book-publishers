package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
