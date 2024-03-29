package com.comment.services;

import com.comment.entities.Comment;

import java.util.List;

public interface CommentService {

    Comment create(Comment comment);
    List<Comment> get();
    Comment getOne(Long id);

    List<Comment> getCommentOfPost(Long postId);
}
