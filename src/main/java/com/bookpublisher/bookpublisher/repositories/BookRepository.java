package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    @Query("SELECT DISTINCT b.category FROM Book b")
    List<String> findDistinctCategory();

    List<Book> findAllByCategory(String category);

    List<Book> findAllByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String title, String category);

    Book findByIsbn(String isbn);

    @Query(value = "SELECT * FROM BOOK WHERE ISBN IN (SELECT ISBN FROM BOOK_AUTHORS WHERE AUTHOR_ID IN (SELECT AUTHOR_ID FROM AUTHOR WHERE UPPER(NAME) LIKE UPPER(?1)))", nativeQuery = true)
    List<Book> findByAuthorName(String authorName);
}