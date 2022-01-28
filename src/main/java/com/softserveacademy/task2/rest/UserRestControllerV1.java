package com.softserveacademy.task2.rest;

import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.exception.UserNotFoundException;
import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestControllerV1 {
    private final UserService userService;

    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") UUID id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromEntity(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> findAll(Model model){
        List<User> users;
        users = userService.findAll();
        if(users == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<UserDto> result = UserDto.fromListEntity(users);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
