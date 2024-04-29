package com.example.twittertrial.Service;

import com.example.twittertrial.DTO.CommentDto;
import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.DTO.UserDto;
import com.example.twittertrial.Entity.Comment;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Entity.User;
import com.example.twittertrial.Repository.PostRepository;
import com.example.twittertrial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public String createPost(PostDto postDto) {
        Optional<User> userOptional = userRepository.findById(postDto.getUserID());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Post post = new Post();
            post.setPostBody(postDto.getPostBody());
            post.setUser(user);
            post.setDate(new Date());
            post.setName(user.getName());
            postRepository.save(post);
            return "Post created successfully";
        } else {
            return "User does not exist";
        }
    }

    public Optional<Post> getPostById(int postId) {
        return postRepository.findById(postId);
    }

    public String editPost(PostDto postDto) {
        Optional<Post> optionalPost = postRepository.findById(postDto.getPostID());
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setPostBody(postDto.getPostBody());
            postRepository.save(post);
            return "Post edited successfully";
        } else {
            return "Post does not exist";
        }
    }

//    public String deletePost(PostDto postDto) {
//        int postId = postDto.getPostID();
//        Optional<Post> postOptional = postRepository.findById(postId);
//        if (postOptional.isPresent()) {
//            postRepository.deleteById(postId);
//            return "Post deleted";
//        } else {
//            return "Post does not exist";
//        }
//    }

    public String deletePost(int postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            postRepository.deleteById(postId);
            return "Post deleted";
        } else {
            return "Post does not exist";
        }
    }


    public List<Post> getAllPosts() {
        // Fetch all posts from the repository and sort them in reverse chronological order
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .sorted((post1, post2) -> post2.getDate().compareTo(post1.getDate()))
                .collect(Collectors.toList());
    }
}
