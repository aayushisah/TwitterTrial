package com.example.twittertrial.Service;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        throw new UserNotFoundException("User does not exist");
    }

}

