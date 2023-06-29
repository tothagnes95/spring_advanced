package com.example.spring_advanced.services;

import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.repositories.PostRepository;
import com.example.spring_advanced.util.PostRetrofitUtil;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostRetrofitServiceImpl implements PostRetrofitService {

    private final PostRepository postRepository;
    private Retrofit retrofit;
    private PostRetrofitAPI postRetrofitAPI;

    public PostRetrofitServiceImpl (PostRepository postRepository) {
        this.postRepository = postRepository;
        retrofit = PostRetrofitUtil.getRetrofitInstance();
        postRetrofitAPI = retrofit.create(PostRetrofitAPI.class);
    }

    @Override
    public List<Post> fetchPosts() {
        List<Post> postList = new ArrayList<>();
        Call<List<Post>> fetchPostCall = postRetrofitAPI.fetchPosts();

        try {
            Response<List<Post>> response = fetchPostCall.execute();
            if(response.isSuccessful() && response.body() != null) {
                postList = response.body();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return postList;
    }

    public void save (Post post) {
        postRepository.save(post);
    }

    public List<Post> findAll () {
        return postRepository.findAll();
    }

    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }
}
