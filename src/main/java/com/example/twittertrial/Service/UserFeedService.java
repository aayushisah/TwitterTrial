package com.example.twittertrial.Service;

import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFeedService {

    private final PostRepository postRepository;

    @Autowired
    public UserFeedService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Object getUserFeed() {
        // Assuming postRepository.findAll() returns a list of posts in reverse chronological order
        List<Object> userFeedData = Collections.singletonList(postRepository.findAll());

        // Additional processing or filtering of user feed data can be done here

        return userFeedData.get(0);
    }

    public List<Post> getAllPosts() {
        // Fetch all posts from the repository and sort them in reverse chronological order
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .sorted((post1, post2) -> post2.getDate().compareTo(post1.getDate()))
                .collect(Collectors.toList());
    }
}
