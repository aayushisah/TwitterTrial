package com.example.twittertrial.Service;

import com.example.twittertrial.DTO.CommentDto;
import com.example.twittertrial.DTO.UserDto;
import com.example.twittertrial.Entity.Comment;
import com.example.twittertrial.Entity.Post;
import com.example.twittertrial.Entity.User;
import com.example.twittertrial.Repository.CommentRepository;
import com.example.twittertrial.Repository.PostRepository;
import com.example.twittertrial.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.*;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public String createComment(CommentDto commentDto) {
        Optional<Post> optionalPost = postRepository.findById(commentDto.getPostID());

        Optional<User> optionalUser = userRepository.findById(commentDto.getUserID());
        if (optionalUser.isEmpty()) {
            return "User does not exist";
        }
        if(optionalPost.isEmpty()) {
            return "Post does not exist";
        }
        //System.out.println("Debug: " + optionalPost);
        if (optionalPost.isPresent()) {

            if (optionalUser.isPresent()) {
                Comment comment = new Comment();
                comment.setCommentBody(commentDto.getCommentBody());
                // Since there's no commentCreator field in CommentDto, you might not need to set it
                // comment.setCommentCreator(commentDto.getCommentCreator());
                comment.setPost(optionalPost.get());
                comment.setUser(optionalUser.get());
                commentRepository.save(comment);
                return "Comment created successfully";
            }
        }
        return "Post does not exist";
    }

    public Optional<Comment> getCommentById(int commentId) {

        Optional<Comment> comment = commentRepository.findById(commentId);
        //System.out.println(comment.get().toString());

        return commentRepository.findById(commentId);
    }

    public String editComment( CommentDto commentDto) {
        Optional<Comment> optionalComment = commentRepository.findById( commentDto.getCommentID());
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setCommentBody(commentDto.getCommentBody());
            commentRepository.save(comment);
            return "Comment edited successfully";
        } else {
            return "Comment does not exist";
        }
    }

    public String deleteComment(CommentDto commentDto) {
        Optional<Comment> optionalComment = commentRepository.findById(commentDto.getCommentID());
        if (optionalComment.isPresent()) {
            commentRepository.deleteById(commentDto.getCommentID());
            return "Comment deleted";
        } else {
            return "Comment does not exist";
        }
    }

    @Autowired
    private ModelMapper modelMapper; // Use modelMapper to convert Entity to DTO

    public CommentDto getCommentByID(int commentID) {
        Comment comment = commentRepository.findById(commentID).orElse(null);
        if (comment != null) {
            return convertToDTO(comment);
        } else {
            return null;
        }
    }

    private CommentDto convertToDTO(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }
}
