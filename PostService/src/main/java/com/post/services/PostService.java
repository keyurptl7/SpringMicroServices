package com.post.services;

import com.post.entities.Post;

import java.util.List;

public interface PostService {

    Post add(Post post);

    List<Post> get();

    Post get(Long id);

}
