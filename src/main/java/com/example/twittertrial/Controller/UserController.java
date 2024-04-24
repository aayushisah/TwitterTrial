package com.example.twittertrial.Controller;

import com.example.twittertrial.DTO.UserLoginRequest;
import com.example.twittertrial.DTO.UserSignupRequest;
import com.example.twittertrial.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginRequest request) {
        return userService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserSignupRequest request) {
        return userService.signup(request.getEmail(), request.getName(), request.getPassword());
    }
    @GetMapping("/users")
    public String getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Long id) {
        return UserService.getUserById(id);
    }
}