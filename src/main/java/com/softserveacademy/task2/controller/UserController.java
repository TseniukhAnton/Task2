package com.softserveacademy.task2.controller;

import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

   // @GetMapping("/user")
//    public String findAll(){
//        List<User> user = userService.findAll();
//
//        //return user;
//    }
}
