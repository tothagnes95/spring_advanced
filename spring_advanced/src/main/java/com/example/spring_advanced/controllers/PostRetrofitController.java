package com.example.spring_advanced.controllers;

import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.services.PostRetrofitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostRetrofitController {

    private final PostRetrofitService postRetrofitService;

    public PostRetrofitController(PostRetrofitService postRetrofitService) {
        this.postRetrofitService = postRetrofitService;
    }

    @GetMapping("/posts")
    public List<Post> fetchPosts () {
        postRetrofitService.fetchPosts().stream().forEach(post -> postRetrofitService.save(post));
        return postRetrofitService.fetchPosts();
    }
}
