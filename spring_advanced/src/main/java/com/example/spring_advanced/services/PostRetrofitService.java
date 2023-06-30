package com.example.spring_advanced.services;

import com.example.spring_advanced.models.DTOs.PostDTO;
import com.example.spring_advanced.models.Post;

import java.util.List;

public interface PostRetrofitService {
    List<Post> fetchPosts();
    void save (Post post);

    List<PostDTO> findAll ();
    PostDTO findPostById(Long id) throws Exception;
}
