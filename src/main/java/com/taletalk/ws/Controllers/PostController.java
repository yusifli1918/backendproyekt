package com.taletalk.ws.Controllers;

import com.taletalk.ws.Entity.Post;
import com.taletalk.ws.requests.PostCreateRequest;
import com.taletalk.ws.requests.PostUpdateRequest;
import com.taletalk.ws.responses.PostResponse;
import com.taletalk.ws.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId  ) {
    return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post CreateOnePost(@RequestBody PostCreateRequest newPostRequest ){
        return postService.createOnePost(newPostRequest);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);

    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatepost ){
        return postService.updateOnePostById(postId, updatepost);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePostById(postId);
    }
}
