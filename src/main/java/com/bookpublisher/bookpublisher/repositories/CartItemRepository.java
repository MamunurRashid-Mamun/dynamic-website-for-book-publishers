package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByBook(Book book);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cart_item WHERE CART_ITEM_ID = ?1", nativeQuery = true)
    Integer deleteByCartItemID(long cartItemId);

    CartItem findByCartItemId(long cartItemId);
}
