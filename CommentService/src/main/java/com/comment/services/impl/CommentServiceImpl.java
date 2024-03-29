package com.comment.services.impl;

import com.comment.entities.Comment;
import com.comment.repositories.CommentRepository;
import com.comment.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> get() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getOne(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found !!"));
    }

    @Override
    public List<Comment> getCommentOfPost(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
