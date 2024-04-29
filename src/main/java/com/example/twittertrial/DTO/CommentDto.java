package com.example.twittertrial.DTO;

import com.example.twittertrial.Entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.modelmapper.ModelMapper;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class CommentDto {
    private int commentID;
    private String commentBody;
    private int postID;
    private int userID; // User ID instead of User object
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate date;

    private User user;


    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostId(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public CommentDto() {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.postID = postID;
        this.userID = userID;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate setDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
