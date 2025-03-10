package com.example.twittertrial.Repository;
import com.example.twittertrial.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAll();
}

//import org.springframework.data.jpa.repository.JpaRepository;
//import com.example.twittertrial.Entity.Post;
//
//public interface PostRepository extends JpaRepository<Post, Integer> {
//}

