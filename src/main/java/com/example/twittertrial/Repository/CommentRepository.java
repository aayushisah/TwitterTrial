package com.example.twittertrial.Repository;// CommentRepository
import com.example.twittertrial.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer > {
    // Custom query methods if needed

}

