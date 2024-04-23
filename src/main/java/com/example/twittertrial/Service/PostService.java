package com.example.twittertrial.Service;

import com.example.twittertrial.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Implement your service methods for creating, retrieving, updating, and deleting posts



}

