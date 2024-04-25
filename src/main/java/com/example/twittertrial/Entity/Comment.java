package com.example.twittertrial.Entity;

import com.example.twittertrial.DTO.UserDto;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentBody;

    // Define relationships with other entities if needed
    // For example:
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name")
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Transient
    private UserDto commentCreator;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /*
    * public void setUser(Long userId) {
        this.user = new User();
        this.user.setId(userId);
    }
    */
    // Add toString() method for debugging and logging
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentBody='" + commentBody + '\'' +
                '}';
    }

    public void setCommentCreator(UserDto commentCreator) {
        this.commentCreator = commentCreator;
    }

}
