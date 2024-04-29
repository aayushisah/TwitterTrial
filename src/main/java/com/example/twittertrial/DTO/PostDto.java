package com.example.twittertrial.DTO;

import com.example.twittertrial.Entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class PostDto {
    private int postID;
    private String postBody;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate date;

    private List<CommentDto> comments;
    private int userID; // User ID instead of User object
    private String name;

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructor, Getters, and Setters

    public PostDto() {
    }

    public PostDto(int postID, String postBody, LocalDate date, List<CommentDto> comments, User user) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
        this.userID = user.getID();
    }

    public PostDto(int postID, String postBody, LocalDate date, List<CommentDto> comments) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
    }

    public int getID() {
        return postID;
    }
}
