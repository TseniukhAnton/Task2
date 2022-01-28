package com.softserveacademy.task2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softserveacademy.task2.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private UUID id;
    private String email;
    private String name;
    private String password;

    public User toEntity() {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return user;
    }

    public static UserDto fromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());

        return userDto;
    }

    public static List<UserDto> fromListEntity(List<User> list) {
        return list.stream().map(UserDto::fromEntity).toList();
    }
}
