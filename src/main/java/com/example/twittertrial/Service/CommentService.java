package com.example.twittertrial.Service;

import com.example.twittertrial.Entity.Comment;
import com.example.twittertrial.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + commentId));
    }

    public Comment updateComment(Long commentId, Comment updatedComment) {
        Comment existingComment = getCommentById(commentId);
        // Update existingComment properties with updatedComment properties
        existingComment.setId(Long.valueOf(updatedComment.getCommentBody()));
        // Update other properties as needed

        return commentRepository.save(existingComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
