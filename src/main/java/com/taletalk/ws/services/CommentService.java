package com.taletalk.ws.services;

import com.taletalk.ws.Entity.Comment;
import com.taletalk.ws.Entity.Post;
import com.taletalk.ws.Entity.User;
import com.taletalk.ws.repos.CommentRepository;
import com.taletalk.ws.requests.CommentCreateRequest;
import com.taletalk.ws.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;


    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }



    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {

        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());

        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());

        } else
            return commentRepository.findAll();
         }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if(user !=null && post !=null){
            Comment comentToSave=new Comment();
            comentToSave.setId(request.getId());
            comentToSave.setPost(post);
            comentToSave.setUser(user);
            comentToSave.setText(request.getText());
            return commentRepository.save(comentToSave);
        }else
        return null;
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest request) {
        Optional<Comment> comment=commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate=comment.get();
            commentToUpdate.setText(request.getText());
            return commentRepository.save(commentToUpdate);

        }else
            return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);

    }
}