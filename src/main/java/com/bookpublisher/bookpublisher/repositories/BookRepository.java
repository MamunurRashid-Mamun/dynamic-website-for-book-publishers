package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Hp on 5/15/18.
 */
@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book,String> {

}
