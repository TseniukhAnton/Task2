package com.softserveacademy.task2.rest;

import com.softserveacademy.task2.dto.AuthenticationRequestDto;
import com.softserveacademy.task2.dto.RegistrationRequestDto;
import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.security.jwt.JwtTokenProvider;
import com.softserveacademy.task2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping(value = "login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String name = requestDto.getName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name, requestDto.getPassword()));
            User user = userService.findByName(name);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + name + " not found");
            }

            String token = jwtTokenProvider.createToken(name, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("name", name);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping(value = "register")
    public ResponseEntity register(@RequestBody RegistrationRequestDto requestDto) {
        try {
            User result = new User();
            //result.setId(UUID.randomUUID());
            result.setName(requestDto.getName());
            result.setEmail(requestDto.getEmail());
            result.setPassword(requestDto.getPassword());
            userService.saveUser(result);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println("Invalid username or password" + e);
        }
        return new ResponseEntity<>(requestDto, HttpStatus.OK);
    }
}