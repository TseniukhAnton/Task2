package com.softserveacademy.task2.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super(String.format("User with email %email not found"));
    }
}
