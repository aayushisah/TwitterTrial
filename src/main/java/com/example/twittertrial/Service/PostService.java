//package com.example.twittertrial.Service;
//
//import com.example.twittertrial.DTO.PostDto;
//import com.example.twittertrial.Entity.Post;
//import com.example.twittertrial.Entity.User;
//import com.example.twittertrial.Repository.PostRepository;
//import com.example.twittertrial.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.Date;
//import java.util.Optional;
//
//@Service
//public class PostService {
//
//    private final PostRepository postRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public PostService(PostRepository postRepository, UserRepository userRepository) {
//        this.postRepository = postRepository;
//        this.userRepository = userRepository;
//    }
//
//    public String createPost(PostDto postDto) {
//        // Retrieve the user from the database using the userID provided in the PostDto
//        User user = userRepository.findById(postDto.getUserID()).orElse(null);
//
//        // If the user exists, create a new Post entity and set its properties
//        if (user != null) {
//            Post post = new Post();
//            post.setPostBody(postDto.getPostBody());
//            post.setUser(user);
//            post.setDate(new Date());
//
//            // Save the post to the database
//            postRepository.save(post);
//            return "Post created successfully";
//        } else {
//            return "User does not exist";
//        }
//    }
//
////    public PostDto getPostById(Long postId) {
////        // Implement logic to get post by ID and return PostDto object
////        Post post = postRepository.findById(postId).orElse(null);
////        PostDto postDto = new PostDto();
////        postDto.setPostID(post.getId());
////        postDto.setPostBody(post.getPostBody());
////        postDto.setDate(post.getDate());
////        postDto.setUserID(post.getUser().getId());
////        return postDto;
////    }
//
//    public Optional<Post> getPostById(Long postId) {
//        // Retrieve the post by its ID from the database
//        return postRepository.findById(postId);
//    }
//
//    public String editPost(Long postId, PostDto postDto) {
//        // Implement logic to edit post and return appropriate message
//        return "Post edited successfully";
//    }
//
//    public String deletePost(Long postId) {
//        // Implement logic to delete post and return appropriate message
//        return "Post deleted";
//    }
//
//}
//
package com.example.twittertrial.Service;

import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Entity.User;
import com.example.twittertrial.Repository.PostRepository;
import com.example.twittertrial.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

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
        // Retrieve the user from the database using the userID provided in the PostDto
        Optional<User> userOptional = userRepository.findById(postDto.getUserID());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Post post = new Post();
            post.setPostBody(postDto.getPostBody());
            post.setUser(user);
            post.setDate(new Date());
            // add name to post
            post.setName(user.getName());
            postRepository.save(post);
            return "Post created successfully";
        } else {
            return "User does not exist";
        }
    }

    public Optional<Post> getPostById(Long postId) {
        return postRepository.findById(postId);
    }

    public String editPost(Long postId, PostDto postDto) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setPostBody(postDto.getPostBody());
            postRepository.save(post);
            return "Post edited successfully";
        } else {
            return "Post does not exist";
        }
    }

    public String deletePost(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            postRepository.deleteById(postId);
            return "Post deleted";
        } else {
            return "Post does not exist";
        }
    }
}
