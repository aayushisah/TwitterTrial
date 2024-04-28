package com.example.twittertrial.Controller;
import com.example.twittertrial.DTO.CommentDto;
import com.example.twittertrial.DTO.PostDto;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Entity.Comment;
import com.example.twittertrial.Entity.User;
import com.example.twittertrial.ErrorClass;
import com.example.twittertrial.Service.PostService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

//    @GetMapping("/post")
//    public ResponseEntity<?> getPostDetails(@RequestParam int postID) {
//        Optional<Post> optionalPost = postService.getPostById(postID);
//        if (optionalPost.isPresent()) {
//            Post post = optionalPost.get();
//            PostDto responseDto = new PostDto();
//            responseDto.setPostID(post.getID());
//            responseDto.setPostBody(post.getPostBody());
//            responseDto.setUserID(post.getUser().getID());
//            responseDto.setDate(post.getDate());
//            responseDto.setName(post.getUser().getName());
//            responseDto.setComments(post.getComments());
//            return ResponseEntity.ok(responseDto);
//        } else {
//            ErrorClass error = new ErrorClass("Post does not exist");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//        }
//    }
@GetMapping("/post")
public ResponseEntity<?> getPostDetails(@RequestParam int postID) {
    Optional<Post> optionalPost = postService.getPostById(postID);
    if (optionalPost.isPresent()) {
        Post post = optionalPost.get();
        // Create a new JSON object to represent the post details
        JSONObject responseObject = new JSONObject();
        responseObject.put("postID", post.getID());
        responseObject.put("postBody", post.getPostBody());
        responseObject.put("date", post.getDate());

        // Create a JSON array to represent comments
        JSONArray commentsArray = new JSONArray();
        for (CommentDto comment : post.getComments()) {
            JSONObject commentObject = new JSONObject();
            commentObject.put("commentID", comment.getCommentID());
            commentObject.put("commentBody", comment.getCommentBody());

            // Retrieve user details and set name
            User user = getUserDetails(comment.getUserID());
            if (user != null) {
                JSONObject commentCreator = new JSONObject();
                commentCreator.put("userID", user.getID());
                commentCreator.put("name", user.getName());
                commentObject.put("commentCreator", commentCreator);
            } else {
                commentObject.put("commentCreator", null);
            }

            commentsArray.add(commentObject);
        }
        responseObject.put("comments", commentsArray);

        // Return the constructed JSON object as the response
        return ResponseEntity.ok(responseObject);
    } else {
        ErrorClass error = new ErrorClass("Post does not exist");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}

    // Method to retrieve user details by user ID
    private User getUserDetails(int userID) {
        // Implement logic to retrieve user details from your data source (e.g., database)
        User user = new User();
        // Return the User object corresponding to the given user ID
        return user;
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
