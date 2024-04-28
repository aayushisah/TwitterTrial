package com.example.twittertrial.Service;

import com.example.twittertrial.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
}
