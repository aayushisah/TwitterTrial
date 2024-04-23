package com.example.twittertrial.Controller;
import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        // Implement logic to create post
        return ResponseEntity.status(HttpStatus.CREATED).body("Post created successfully");
    }

    @GetMapping
    public ResponseEntity<PostDto> getPost(@RequestParam Long postID) {
        // Implement logic to retrieve post by ID
        return ResponseEntity.ok().body(new PostDto());
    }

    @PatchMapping
    public ResponseEntity<String> editPost(@RequestBody PostDto postDto) {
        // Implement logic to edit post
        return ResponseEntity.ok().body("Post edited successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam Long postID) {
        // Implement logic to delete post by ID
        return ResponseEntity.ok().body("Post deleted successfully");
    }
}

