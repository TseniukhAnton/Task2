package com.softserveacademy.task2.repository;

import com.softserveacademy.task2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("select b from User b where b.email = :email")
    User findByEmail(@Param("email") String email);

    User findByName(String name);
}
