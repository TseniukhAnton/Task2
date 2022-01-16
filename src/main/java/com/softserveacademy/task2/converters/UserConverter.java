package com.softserveacademy.task2.converters;

import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public UserDto convert(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        return dto;
    }
}
