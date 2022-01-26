package com.softserveacademy.task2.security;

import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.security.jwt.JwtUser;
import com.softserveacademy.task2.security.jwt.JwtUserFactory;
import com.softserveacademy.task2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + name + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", name);
        return jwtUser;
    }
}
