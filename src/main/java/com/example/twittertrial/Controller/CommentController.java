package com.example.twittertrial.Controller;

import com.example.twittertrial.DTO.CommentDto;
import com.example.twittertrial.Entity.Comment;
import com.example.twittertrial.ErrorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import  CommentService;
import com.example.twittertrial.Service.CommentService;
import com.example.twittertrial.DTO.CommentDto;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentDto commentDto) {
        String result = commentService.createComment(commentDto);
        if (result.equals("Comment created successfully")) {
            return ResponseEntity.ok(result);
        } else {
            if(result.equals("User does not exist") ) {

                ErrorClass error = new ErrorClass("User does not exist");

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            else {
                ErrorClass error = new ErrorClass("Post does not exist");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }
        }
    }

    @GetMapping
    public ResponseEntity<?> getCommentDetails(@RequestParam int commentID) {
        Optional<Comment> optionalComment = commentService.getCommentById(commentID);
        if (optionalComment.isPresent()) {
            return ResponseEntity.ok(optionalComment.get());
        } else {
            ErrorClass error = new ErrorClass("Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @PatchMapping
    public ResponseEntity<?> editComment(@RequestBody CommentDto commentDto) {
        String result = commentService.editComment(commentDto);
        if (result.equals("Comment edited successfully")) {
            return ResponseEntity.ok(result);
        } else {
            ErrorClass error = new ErrorClass("Comment does not exist");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

//    @DeleteMapping
//    public ResponseEntity<String> deleteComment(@RequestBody CommentDto commentDto) {
//        String result = commentService.deleteComment(commentDto);
//        if (result.equals("Comment deleted")) {
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
//        }
//    }

    @DeleteMapping
    public ResponseEntity<?> deleteComment(@RequestParam int commentID) {
        String result = commentService.deleteComment(commentID);
        if (result.equals("Comment deleted")) {
            return ResponseEntity.ok(result);
        } else {
                ErrorClass error = new ErrorClass("Comment does not exist");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

}
