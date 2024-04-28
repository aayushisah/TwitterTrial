package com.example.twittertrial.Controller;

import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.DTO.UserDto;
import com.example.twittertrial.DTO.UserLoginRequest;
import com.example.twittertrial.DTO.UserSignupRequest;
import com.example.twittertrial.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/user")
    public ResponseEntity<?> getUserDetails(@RequestParam int userID) {
        Optional<UserDto> optionalUserDto = userService.getUserDetails(userID);
        if (optionalUserDto.isPresent()) {
            return ResponseEntity.ok(optionalUserDto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }
}