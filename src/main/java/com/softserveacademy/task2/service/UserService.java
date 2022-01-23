package com.softserveacademy.task2.service;

import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto findById(UUID id);
    List<UserDto> findAll();
    UserDto saveUser(User user);
    void deleteById(UUID id)    ;
    UserDto getByEmail(String email);
}
