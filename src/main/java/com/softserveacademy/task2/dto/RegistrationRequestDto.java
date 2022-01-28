package com.softserveacademy.task2.dto;

import lombok.Data;

@Data
public class RegistrationRequestDto {
    private String name;
    private String email;
    private String password;
}
