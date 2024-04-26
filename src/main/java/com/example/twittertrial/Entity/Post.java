package com.example.twittertrial.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_body")
    private String postBody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public void setID(Long id) {
        this.id = id;
    }

    public Long getID() {
        return id;
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

    public void setUser(Long userID) {
        this.user = new User();
        this.user.setID(userID);
    }

    public void getUser(Long userID) {
        this.user = new User();
        this.user.setID(userID);
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    // Constructor, Getters, and Setters
}

