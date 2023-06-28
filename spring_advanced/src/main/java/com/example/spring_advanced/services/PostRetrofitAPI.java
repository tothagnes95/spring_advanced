package com.example.spring_advanced.services;

import com.example.spring_advanced.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PostRetrofitAPI {
    @GET("/posts")
    Call<List<Post>> fetchPosts();
}
