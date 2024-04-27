package com.example.twittertrial.Entity;

import com.example.twittertrial.DTO.CommentDto;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @Column(name = "post_body")
    private String postBody;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // Constructor, other methods...
}
