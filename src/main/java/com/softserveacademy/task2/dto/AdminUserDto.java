package com.softserveacademy.task2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softserveacademy.task2.model.Status;
import com.softserveacademy.task2.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private String email;
    private String name;
    private String password;

    public User toUser() {
        return User.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setName(user.getName());
        adminUserDto.setPassword(user.getPassword());
        return adminUserDto;
    }
}}
