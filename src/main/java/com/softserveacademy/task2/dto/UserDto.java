package com.softserveacademy.task2.dto;

import com.softserveacademy.task2.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
public class UserDto {
    private String id;
    private String email;
    private String name;
    private String password;

    public User toEntity() {
        return User.builder()
                .id(UUID.fromString(id))
                .email(email)
                .name(name)
                .password(password)
                .build();
    }

    public static UserDto fromEntity(User user) {
        return Objects.nonNull(user) ?
                UserDto.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .build() : null;

    }
}
