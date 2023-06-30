package com.example.spring_advanced.services;

import com.example.spring_advanced.models.DTOs.PostDTO;
import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.repositories.PostRepository;
import com.example.spring_advanced.util.PostRetrofitUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostRetrofitServiceImpl implements PostRetrofitService {

    private final PostRepository postRepository;
    private Retrofit retrofit;
    private PostRetrofitAPI postRetrofitAPI;

    @Autowired
    private ModelMapper modelMapper;

    public PostRetrofitServiceImpl (PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        retrofit = PostRetrofitUtil.getRetrofitInstance();
        postRetrofitAPI = retrofit.create(PostRetrofitAPI.class);
        this.modelMapper = modelMapper;
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

    public List<PostDTO> findAll () {
        return postRepository.findAll().stream().map(o -> this.modelMapper.map(o, PostDTO.class)).collect(Collectors.toList());
    }

    public PostDTO findPostById(Long id) throws Exception {
        Post post = postRepository.findById(id).orElseThrow(() -> new Exception("no post found"));
        PostDTO postDTO = this.modelMapper.map(post, PostDTO.class);
        return postDTO;
    }
}
