package com.example.twittertrial.Controller;
import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.ErrorClass;
import com.example.twittertrial.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto) {
        String result = postService.createPost(postDto);
        if (result.equals("Post created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            ErrorClass error = new ErrorClass("User does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @GetMapping("/post")
    public ResponseEntity<?> getPostDetails(@RequestParam int postID) {
        Optional<Post> optionalPost = postService.getPostById(postID);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            PostDto responseDto = new PostDto();
            responseDto.setPostID(post.getID());
            responseDto.setPostBody(post.getPostBody());
            responseDto.setUserID(post.getUser().getID());
            responseDto.setDate(post.getDate());
            responseDto.setName(post.getUser().getName());
            responseDto.setComments(post.getComments());
            return ResponseEntity.ok(responseDto);
        } else {
            ErrorClass error = new ErrorClass("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @PatchMapping("/post")
    public ResponseEntity<?> editPost(@RequestBody PostDto postDto) {
        String result = postService.editPost(postDto);
        if (result.equals("Post edited successfully")) {
            return ResponseEntity.ok(result);
        } else {
            ErrorClass error = new ErrorClass("Post does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

//    @DeleteMapping("/post") // the old request body method ;-; sad to see you go
//    public ResponseEntity<String> deletePost(@RequestBody PostDto postDto) {
//        String result = postService.deletePost(postDto);
//        if (result.equals("Post deleted")) {
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
//        }
//    }

        @DeleteMapping("/post")
        public ResponseEntity<?> deletePost(@RequestParam int postID) {
            String result = postService.deletePost(postID);
            if (result.equals("Post deleted")) {
                return ResponseEntity.ok(result);
            } else {
                ErrorClass error = new ErrorClass("Post does not exist");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
        }

}
