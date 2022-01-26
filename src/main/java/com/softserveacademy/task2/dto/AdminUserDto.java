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
    private UUID id;
    private String email;
    private String name;
    private String password;
    private String status;

    public User toUser() {
        return User.builder()
                .id(UUID.fromString(id))
                .email(email)
                .name(name)
                .password(password)
                .status(Status.valueOf(status))
                .build();
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setName(user.getName());
        adminUserDto.setPassword(user.getPassword());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
}}
