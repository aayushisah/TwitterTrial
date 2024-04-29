package com.example.twittertrial.Controller;

import com.example.twittertrial.Entity.Comment;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Entity.User;
import com.example.twittertrial.Service.UserFeedService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserFeedController {

    private final UserFeedService userFeedService;

    @Autowired
    public UserFeedController(UserFeedService userFeedService) {
        this.userFeedService = userFeedService;
    }

//    @GetMapping("/")
//    public ResponseEntity<?> getUserFeed() {
//        try {
//            // Call the service method to retrieve user feed
//            // Assuming userFeedService.getUserFeed() returns the user feed data
//            Object userFeedData = userFeedService.getUserFeed();
//
//            // Return the user feed data with status 200 OK
//            return ResponseEntity.ok(userFeedData);
//        } catch (Exception e) {
//            // Handle exceptions and return appropriate error response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An error occurred while fetching user feed data");
//        }
//    }


    @GetMapping("/")
    public ResponseEntity<?> getUserFeed() {
        List<Post> posts = userFeedService.getAllPosts();

        // Create a JSON array to represent all posts
        JSONArray postsArray = new JSONArray();
        for (Post post : posts) {
            // Create a new JSON object to represent the post details
            JSONObject postObject = new JSONObject();
            postObject.put("postID", post.getID());
            postObject.put("postBody", post.getPostBody());
            postObject.put("date", post.getDate());

            // Create a JSON array to represent comments
            JSONArray commentsArray = new JSONArray();
            for (Comment comment : post.getComments()) {
                JSONObject commentObject = new JSONObject();
                commentObject.put("commentID", comment.getID());
                commentObject.put("commentBody", comment.getCommentBody());

                // Retrieve user details and set name
                User user = comment.getUser();
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
            postObject.put("comments", commentsArray);

            // Add the post object to the posts array
            postsArray.add(postObject);
        }

        // Return the constructed JSON array as the response
        return ResponseEntity.ok(postsArray);
    }
}
