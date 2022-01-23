package com.softserveacademy.task2.service.impl;

import com.softserveacademy.task2.converters.UserConverter;
import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.repository.UserRepository;
import com.softserveacademy.task2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public UserDto findById(UUID id) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        return userConverter.convert(user);
    }

    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userConverter::convert).toList();
    }

    @Transactional
    public UserDto saveUser(User user) {
        User user1 = userRepository.saveAndFlush(user);
        return userConverter.convert(user1);
    }

    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getByEmail(String email) {
        User userByEmail = userRepository.findByEmail(email);
        return userConverter.convert(userByEmail);
    }

}
