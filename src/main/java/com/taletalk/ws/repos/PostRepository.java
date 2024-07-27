package com.taletalk.ws.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taletalk.ws.Entity.Post;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
