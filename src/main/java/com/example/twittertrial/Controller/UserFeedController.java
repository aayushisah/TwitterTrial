package com.example.twittertrial.Controller;

import com.example.twittertrial.Service.UserFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserFeedController {

    private final UserFeedService userFeedService;

    @Autowired
    public UserFeedController(UserFeedService userFeedService) {
        this.userFeedService = userFeedService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getUserFeed() {
        try {
            // Call the service method to retrieve user feed
            // Assuming userFeedService.getUserFeed() returns the user feed data
            Object userFeedData = userFeedService.getUserFeed();

            // Return the user feed data with status 200 OK
            return ResponseEntity.ok(userFeedData);
        } catch (Exception e) {
            // Handle exceptions and return appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching user feed data");
        }
    }
}
