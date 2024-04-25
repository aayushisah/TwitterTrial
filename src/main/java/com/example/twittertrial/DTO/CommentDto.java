//package com.example.twittertrial.DTO;
//
//import com.example.twittertrial.DTO.UserDto;
//
//public class CommentDto {
//    private Long commentID;
//    private String commentBody;
//    private UserDto commentCreator;
//    private Long postId;
//    private Long userID; // User ID instead of User object
//    private String name;
//
//
//    public Long getCommentID() {
//        return commentID;
//    }
//
//    public void setCommentID(Long commentID) {
//        this.commentID = commentID;
//    }
//
//    public String getCommentBody() {
//        return commentBody;
//    }
//
//    public void setCommentBody(String commentBody) {
//        this.commentBody = commentBody;
//    }
//
//    public UserDto getCommentCreator() {
//        return commentCreator;
//    }
//
//    public void setCommentCreator(UserDto commentCreator) {
//        this.commentCreator = commentCreator;
//    }
//
//    public Long getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Long postId) {
//        this.postId = postId;
//    }
//
//    public Long getUserID() {
//        return userID;
//    }
//
//    public void setUserID(Long userID) {
//        this.userID = userID;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//    public CommentDto(Long commentID, String commentBody, UserDto commentCreator, Long postId) {
//        this.commentID = commentID;
//        this.commentBody = commentBody;
//        this.commentCreator = commentCreator;
//        this.postId = postId;
//    }
//
//    public Long getUserId() {
//        return commentCreator.getUserId();
//    }
//}
package com.example.twittertrial.DTO;

import com.example.twittertrial.DTO.UserDto;

public class CommentDto {
    private Long commentID;
    private String commentBody;
    private UserDto commentCreator;
    private Long postId;
    private Long userID; // User ID instead of User object

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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public CommentDto(Long commentID, String commentBody, UserDto commentCreator, Long postId) {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.commentCreator = commentCreator;
        this.postId = postId;
    }

    public Long getUserId() {
        return commentCreator.getUserId();
    }
}
