package com.taletalk.ws.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taletalk.ws.Entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUserIdAndPostId(Long userId, Long postId);

    List<Comment> findByUserId(Long userId);

    List<Comment> findByPostId(Long postId);
}

