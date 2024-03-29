package com.post.controllers;

import com.post.entities.Post;
import com.post.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //    create
    @PostMapping
    public Post create(@RequestBody Post post) {
        return postService.add(post);
    }

//    get all

    @GetMapping
    public List<Post> get() {
        return postService.get();
    }

    @GetMapping("/{id}")
    public Post getOne(@PathVariable Long id) {
        return postService.get(id);
    }


}
