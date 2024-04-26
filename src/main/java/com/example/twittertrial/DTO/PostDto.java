package com.example.twittertrial.DTO;

import com.example.twittertrial.Entity.User;

import java.util.Date;
import java.util.List;

public class PostDto {
    private Long postID;
    private String postBody;
    private Date date;
    private List<CommentDto> comments;
    private Long userID; // User ID instead of User object
    private String name;

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
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

    public PostDto(Long postID, String postBody, Date date, List<CommentDto> comments, User user) {
        this.postID = postID;
        this.postBody = postBody;
        this.date = date;
        this.comments = comments;
        this.userID = user.getID();
    }
}
