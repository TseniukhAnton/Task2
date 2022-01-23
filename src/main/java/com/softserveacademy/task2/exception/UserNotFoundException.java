package com.softserveacademy.task2.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String email) {
        super(String.format("User with email %email not found", email));
    }
}
