package com.comment.controllers;

import com.comment.entities.Comment;
import com.comment.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //    create
    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    //    get all
    @GetMapping
    public List<Comment> getAll() {
        return commentService.get();
    }

    @GetMapping("/{commentId}")
    public Comment getAll(@PathVariable Long commentId) {
        return commentService.getOne(commentId);
    }

//    get all comments of specific post
    @GetMapping("/post/{postId}")
    public List<Comment> getCommentOfPost(@PathVariable Long postId) {
        return commentService.getCommentOfPost(postId);
    }

}
