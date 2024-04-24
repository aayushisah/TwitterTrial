//package com.example.twittertrial.Controller;//package com.example.twittertrial.Controller;
////
////import com.example.twittertrial.Entity.Post;
////import com.example.twittertrial.Service.PostService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////public class PostController {
////
////    private final PostService postService;
////
////    @Autowired
////    public PostController(PostService postService) {
////        this.postService = postService;
////    }
////
////    @PostMapping("/post")
////    public Post createPost(@RequestBody Post post) {
////        return postService.createPost(post);
////    }
////
////    @GetMapping("/post/{postId}")
////    public Post getPostDetails(@PathVariable Long postId) {
////        return postService.getPostById(postId);
////    }
////
////    @PatchMapping("/post/{postId}")
////    public Post editPost(@PathVariable Long postId, @RequestBody Post updatedPost) {
////        return postService.editPost(postId, updatedPost);
////    }
////
////    @DeleteMapping("/post/{postId}")
////    public void deletePost(@PathVariable Long postId) {
////        postService.deletePost(postId);
////    }
////
////    @GetMapping("/all posts")
////    public List<Post> getAllPosts() {
////        return postService.getAllPosts();
////    }
////}

package com.example.twittertrial.Controller;

import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping("/{postId}")
    public PostDto getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @PatchMapping("/{postId}")
    public String editPost(@PathVariable Long postId, @RequestBody PostDto postDto) {
        return postService.editPost(postId, postDto);
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
        return postService.deletePost(postId);
    }
}
