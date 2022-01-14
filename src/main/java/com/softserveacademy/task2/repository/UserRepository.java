package com.softserveacademy.task2.repository;

import com.softserveacademy.task2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
