package com.example.twittertrial.DTO;

// UserSignupRequest.java
public class UserSignupRequest {
    private String email;
    private String name;
    private String password;

    // Default constructor
    public UserSignupRequest() {
    }

    // Parameterized constructor
    public UserSignupRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
