package com.softserveacademy.task2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softserveacademy.task2.model.Status;
import com.softserveacademy.task2.model.User;
import lombok.Data;

import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private UUID id;
    private String email;
    private String name;
    private String password;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        return user;
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
}
