package com.bookpublisher.bookpublisher.repositories;

import com.bookpublisher.bookpublisher.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
