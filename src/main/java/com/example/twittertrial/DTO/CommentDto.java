package com.example.twittertrial.DTO;

import com.example.twittertrial.DTO.UserDto;

public class CommentDto {
    private Long commentID;
    private String commentBody;
    private UserDto commentCreator;

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public UserDto getCommentCreator() {
        return commentCreator;
    }

    public void setCommentCreator(UserDto commentCreator) {
        this.commentCreator = commentCreator;
    }
}
