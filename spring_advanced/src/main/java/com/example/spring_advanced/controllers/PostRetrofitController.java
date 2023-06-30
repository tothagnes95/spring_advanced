package com.example.spring_advanced.controllers;

import com.example.spring_advanced.models.DTOs.PostDTO;
import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.services.PostRetrofitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostRetrofitController {

    private final PostRetrofitService postRetrofitService;

    public PostRetrofitController(PostRetrofitService postRetrofitService) {
        this.postRetrofitService = postRetrofitService;
    }

    @GetMapping("/posts")
    public List<PostDTO> fetchPosts () {
        postRetrofitService.fetchPosts().stream().forEach(post -> postRetrofitService.save(post));
        return postRetrofitService.findAll();
    }

    @GetMapping("/listPosts")
    public ResponseEntity<List<PostDTO>> listAllPost () {
        return ResponseEntity.ok(postRetrofitService.findAll());
    }

    @GetMapping("/findById")
    public ResponseEntity<PostDTO> findById (@RequestParam Long id) throws Exception {
        return ResponseEntity.ok(postRetrofitService.findPostById(id));
    }
}
