package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
    User findByEmail(String email);
    User findByUserNameOrEmail(String userName, String Email);

    @Transactional //transactional is use for cascade delete.
    void deleteByUserNameOrEmail(String username, String email);

    @Transactional
    void deleteByUserName(String userName);
}
