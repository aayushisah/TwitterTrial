package com.example.twittertrial.DTO;

public class CommentDto {
    private Long commentID;
    private String commentBody;
    private Long postID;
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

    public Long getPostID() {
        return postID;
    }

    public void setPostId(Long postID) {
        this.postID = postID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public CommentDto(Long commentID, String commentBody, Long postID, Long userID) {
        this.commentID = commentID;
        this.commentBody = commentBody;
        this.postID = postID;
        this.userID = userID;
    }
}
