package com.example.twittertrial.DTO;

import java.util.List;

public class UserDto {
    private int userID;
    private String name;
    private String email;

    public UserDto(int userId, String name) {
        // Constructor logic

        this.userID = userId;
        this.name = name;

    }

    public UserDto() {
        // Constructor logic

    }

    public UserDto(String name, int id, String email) {
        this.name = name;
        this.userID = id;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int id) {
        this.userID = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosts(PostDto posts) {



    }
    private List<PostDto> posts_created; //why is this never accessed

    public void setPosts(List<PostDto> postDtos) {
        this.posts_created = postDtos;
    }

}

