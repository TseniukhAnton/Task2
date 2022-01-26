package com.softserveacademy.task2.service;

import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User register(User user);

    User findById(UUID id);

    List<User> findAll();

    User saveUser(User user);

    void deleteById(UUID id);

    User getByEmail(String email);

    User findByName(String name);

}
