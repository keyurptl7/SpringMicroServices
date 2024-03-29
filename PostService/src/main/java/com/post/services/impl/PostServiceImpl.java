package com.post.services.impl;

import com.post.entities.Post;
import com.post.repositories.PostRepository;
import com.post.services.CommentClient;
import com.post.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private CommentClient commentClient;

    public PostServiceImpl(PostRepository postRepository, CommentClient commentClient) {
        this.postRepository = postRepository;
        this.commentClient = commentClient;
    }

    @Override
    public Post add(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> get() {
        List<Post> posts = postRepository.findAll();

        List<Post> newPostList = posts.stream().map(post -> {
            post.setComments(commentClient.getCommentOfPost(post.getId()));
            return post;
        }).collect(Collectors.toList());

        return newPostList;
    }

    @Override
    public Post get(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setComments(commentClient.getCommentOfPost(post.getId()));
        return post;
    }
}
