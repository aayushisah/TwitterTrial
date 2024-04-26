package com.example.twittertrial.Service;

import com.example.twittertrial.Entity.User;
import com.example.twittertrial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "User does not exist";
        } else if (!user.getPassword().equals(password)) {
            return "Username/Password Incorrect";
        } else {
            return "Login Successful";
        }
    }

    public String signup(String email, String name, String password) {
        try {
            User existingUser = userRepository.findByEmail(email);
            if (existingUser != null) {
                return "Forbidden, Account already exists";
            } else {
                User newUser = new User();
                newUser.setEmail(email);
                newUser.setName(name);
                newUser.setPassword(password);
                userRepository.save(newUser);
                return "Account Creation Successful";
            }
        } catch (DataIntegrityViolationException e) {
            return "Error: " + e.getRootCause().getMessage(); // Handle unique constraint violation
        } catch (Exception e) {
            return "Error: " + e.getMessage(); // Handle other exceptions
        }
    }

    public User getUserById(Long userID) {
        return userRepository.findById(userID).orElse(null);
    }
}
