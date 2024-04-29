package com.example.twittertrial.Controller;

import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.DTO.UserDto;
import com.example.twittertrial.DTO.UserLoginRequest;
import com.example.twittertrial.DTO.UserSignupRequest;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Entity.User;
import com.example.twittertrial.ErrorClass;
import com.example.twittertrial.Repository.UserRepository;
import com.example.twittertrial.Service.PostService;
import com.example.twittertrial.Service.UserNotFoundException;
import com.example.twittertrial.Service.UserService;
import com.example.twittertrial.Repository.UserRepository;

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
    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/login")
//    public String login(@RequestBody UserLoginRequest request) {
//        return userService.login(request.getEmail(), request.getPassword());
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
        // Perform login logic here
        String email = userLoginRequest.getEmail();
        String password = userLoginRequest.getPassword();

        // Check if user exists and credentials are correct
        if (isValidUser(email, password)) {
            // Return success message
            return ResponseEntity.ok("Login Successful");
        } else {
            // Return error message
            //   return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            //      .body(new Error("Username/Password Incorrect or User does not exist"));
            if(userRepository.findByEmail(email) == null) {
                ErrorClass error = new ErrorClass("User does not exist");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            else
            {
                ErrorClass error = new ErrorClass("Username/Password Incorrect");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
        }
    }

    public boolean isValidUser(String email, String password) {
        // Fetch user by email from UserRepository
        User user = userRepository.findByEmail(email);

        // Check if the user exists and if the provided password matches
        return user != null && user.getPassword().equals(password);
    }


//    @PostMapping("/signup")
//    public String signup(@RequestBody UserSignupRequest request) {
//        return userService.signup(request.getEmail(), request.getName(), request.getPassword());
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSignupRequest userSignupRequest) {
        // Perform signup logic here
        String email = userSignupRequest.getEmail();
        String name = userSignupRequest.getName();
        String password = userSignupRequest.getPassword();

        // Check if user exists
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            // Return error message
            //return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account already exists");
            ErrorClass error = new ErrorClass("Forbidden, Account already exists");

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
        }
        return ResponseEntity.ok(userService.signup(email, name, password));
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserDetails(@RequestParam int userID) {
        Optional<UserDto> optionalUserDto = userService.getUserDetails(userID);
        if (optionalUserDto.isPresent()) {
            return ResponseEntity.ok(optionalUserDto.get());
        } else {
            // throw new UserNotFoundException("User does not exist");
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
            ErrorClass error = new ErrorClass("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }


}