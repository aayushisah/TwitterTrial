package com.example.twittertrial.Controller;

import com.example.twittertrial.DTO.CommentDto;
import com.example.twittertrial.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import  CommentService;
import com.example.twittertrial.Service.CommentService;
import com.example.twittertrial.DTO.CommentDto;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentDto commentDto) {
        String result = commentService.createComment(commentDto);
        if (result.equals("Comment created successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<?> getCommentDetails(@PathVariable Long commentId) {
        Optional<Comment> optionalComment = commentService.getCommentById(commentId);
        if (optionalComment.isPresent()) {
            return ResponseEntity.ok(optionalComment.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment does not exist");
        }
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<String> editComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        String result = commentService.editComment(commentId, commentDto);
        if (result.equals("Comment edited successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        String result = commentService.deleteComment(commentId);
        if (result.equals("Comment deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
}
