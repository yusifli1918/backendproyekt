package com.taletalk.ws.Controllers;


import com.taletalk.ws.Entity.Comment;
import com.taletalk.ws.requests.CommentCreateRequest;
import com.taletalk.ws.requests.CommentUpdateRequest;
import com.taletalk.ws.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/comments")
public class CommentControllers {

    private CommentService commentService;

    public CommentControllers(CommentService commentService) {

        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {

        return commentService.getAllCommentsWithParam(userId, postId);
    }

    @PostMapping
    public  Comment createOneComment(@RequestBody CommentCreateRequest request){
        return commentService.createOneComment(request);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId){

        return commentService.getOneCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request){
        return commentService.updateOneCommentById(commentId, request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
    }
}
