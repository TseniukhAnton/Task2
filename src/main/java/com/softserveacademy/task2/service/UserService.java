package com.softserveacademy.task2.service;

import com.softserveacademy.task2.converters.UserConverter;
import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public UserDto findById(UUID id) {
        User user = userRepository.findById(id).orElse(null);
        UserConverter converter = new UserConverter();
        assert user != null;
        return converter.convert(user);
    }


    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userConverter::convert).toList();
    }

    public UserDto saveUser(User user) {
        User user1 = userRepository.save(user);
        return userConverter.convert(user1);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }


}
