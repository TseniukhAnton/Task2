package com.softserveacademy.task2.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String name;
    private String password;
}
