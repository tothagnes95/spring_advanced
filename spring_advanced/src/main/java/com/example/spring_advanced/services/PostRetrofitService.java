package com.example.spring_advanced.services;

import com.example.spring_advanced.models.Post;

import java.util.List;

public interface PostRetrofitService {
    List<Post> fetchPosts();
}
