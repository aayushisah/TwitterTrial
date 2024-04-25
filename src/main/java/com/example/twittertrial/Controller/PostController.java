//package com.example.twittertrial.Controller;
//
//import com.example.twittertrial.DTO.PostDto;
//import com.example.twittertrial.Entity.Post;
//import com.example.twittertrial.Service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/post")
//public class PostController {
//
//    private final PostService postService;
//
//    @Autowired
//    public PostController(PostService postService) {
//        this.postService = postService;
//    }
//
//    @PostMapping
//    public String createPost(@RequestBody PostDto postDto) {
//        return postService.createPost(postDto);
//    }
//
//    @GetMapping("/{postId}")
//    public ResponseEntity<?> getPostDetails(@PathVariable Long postId) {
//        Optional<Post> optionalPost = postService.getPostById(postId);
//        if (optionalPost.isPresent()) {
//            return ResponseEntity.ok(optionalPost.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post does not exist");
//        }
//    }
//
////    @GetMapping("/{postId}")
////    public PostDto getPost(@PathVariable Long postId) {
////        return postService.getPostById(postId);
////    }
//
//    @PatchMapping("/{postId}")
//    public String editPost(@PathVariable Long postId, @RequestBody PostDto postDto) {
//        return postService.editPost(postId, postDto);
//    }
//
//    @DeleteMapping("/{postId}")
//    public String deletePost(@PathVariable Long postId) {
//        return postService.deletePost(postId);
//    }
//}

package com.example.twittertrial.Controller;

import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDto postDto) {
        String result = postService.createPost(postDto);
        if (result.equals("Post created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostDetails(@PathVariable Long postId) {
        Optional<Post> optionalPost = postService.getPostById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            PostDto responseDto = new PostDto();
            responseDto.setPostId(post.getId());
            responseDto.setPostBody(post.getPostBody());
            responseDto.setUserID(post.getUser().getId());
            responseDto.setDate(post.getDate());
            responseDto.setName(post.getUser().getName());
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post does not exist");
        }
    }


    @PatchMapping
    public ResponseEntity<String> editPost(@RequestBody PostDto postDto) {
        String result = postService.editPost(postDto);
        if (result.equals("Post edited successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestBody Long postId) {
        String result = postService.deletePost(postId);
        if (result.equals("Post deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

}
