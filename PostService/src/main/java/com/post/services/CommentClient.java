package com.post.services;

import com.post.entities.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8082",value = "Comment-Client")
@FeignClient(name = "COMMENT-SERVICE")
public interface CommentClient {

    @GetMapping("/comment/post/{postId}")
    List<Comment> getCommentOfPost(@PathVariable Long postId);
}
