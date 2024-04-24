package com.example.twittertrial.Service;

import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public String createPost(PostDto postDto) {
        // Implement logic to create post and return appropriate message
        Post post = new Post();
        post.setPostBody(postDto.getPostBody());
        post.setDate(postDto.getDate());
        post.setId(postDto.getUserID());
        
        postRepository.save(post);

        return "Post created successfully";
    }
    public PostDto getPost(Long postId) {
        // Implement logic to retrieve post and return PostDto or relevant error

        return new PostDto();
    }

    public String editPost(Long postId, PostDto postDto) {
        // Implement logic to edit post and return appropriate message
        return "Post edited successfully";
    }

    public String deletePost(Long postId) {
        // Implement logic to delete post and return appropriate message
        return "Post deleted";
    }

}
    