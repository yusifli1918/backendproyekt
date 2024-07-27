package com.taletalk.ws.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taletalk.ws.Entity.Like;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserIdAndPostId(Long userId, Long postId);

    List<Like> findByUserId(Long userId);

    List<Like> findByPostId(Long postId);
}
