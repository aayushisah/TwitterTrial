package com.example.twittertrial.Entity;

import com.example.twittertrial.DTO.CommentDto;
import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.DTO.UserDto;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String name;
    private String password;

    // Constructors, getters, and setters

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;

    // Constructor, getters, and setters...
    public List<PostDto> getPosts() {
        return posts.stream()
//                .map(post -> new PostDto(
//                        post.getID(),
//                        post.getPostBody(),
//                        post.getDate(),
//                        post.getComments().stream()
//                                .map(comment -> new CommentDto(
//                                        comment.getID(),
//                                        comment.getCommentBody(),
//                                        new UserDto(
//                                                comment.getCommentCreator().getUserID(),
//                                                comment.getCommentCreator().getName()
//                                        ),
//                                        comment.getPost().getID()
//                                ))
//                                .collect(Collectors.toList())
//                ))
                .map(post -> new PostDto(
                        post.getID(),
                        post.getPostBody(),
                        post.getDate(),
                        post.getComments().stream()
                                .map(comment -> new CommentDto(
                                        comment.getID(),
                                        comment.getCommentBody(),
                                        new UserDto(
                                                comment.getCommentCreator().getUserID(), // Use getID() method to get userID
                                                comment.getCommentCreator().getName() // Use getName() method to get name
                                        ).getUserID(),
                                        comment.getPost().getID()
                                ))
                                .collect(Collectors.toList())
                ))

                .collect(Collectors.toList());

    }


}
