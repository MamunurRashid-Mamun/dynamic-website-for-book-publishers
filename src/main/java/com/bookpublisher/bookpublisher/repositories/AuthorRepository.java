package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Author findById(long id);
}
