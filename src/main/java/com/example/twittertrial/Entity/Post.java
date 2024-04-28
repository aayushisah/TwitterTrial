package com.example.twittertrial.Entity;

import com.example.twittertrial.DTO.CommentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "post_id")
    private int postID;

    @Column(name = "post_body")
    private String postBody;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public int getID() {
        return postID;
    }

    public void setID(int id) {
        this.postID = id;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUser(int userId) {
        this.user = new User();
        this.user.setID(userId);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // get comments for post
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)//what should it be mapped by?
    private List<Comment> comments;

    public List<CommentDto> getComments() {
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDto commentDto = new CommentDto();
            commentDto.setCommentID(comment.getID());
            commentDto.setCommentBody(comment.getCommentBody());
            commentDto.setUserID(comment.getUser().getID());
            commentDto.setName(comment.getName());
            commentDto.setDate(comment.getDate());
            commentDtos.add(commentDto);
        }
        return commentDtos;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // Constructor, other methods...
}
