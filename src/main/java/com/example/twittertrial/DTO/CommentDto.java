package com.example.twittertrial.DTO;

public class CommentDto {
    private int commentID;
    private String commentBody;
    private int postID;
    private int userID; // User ID instead of User object

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

    public CommentDto(int commentID, String commentBody, int postID, int userID) {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.postID = postID;
        this.userID = userID;
    }
}
