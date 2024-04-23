package com.example.twittertrial.DTO;

// UserLoginRequest.java
public class UserLoginRequest {
    private String email;
    private String password;

    // Default constructor
    public UserLoginRequest() {
    }

    // Parameterized constructor
    public UserLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

