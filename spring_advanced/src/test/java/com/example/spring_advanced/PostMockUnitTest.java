package com.example.spring_advanced;

import com.example.spring_advanced.models.DTOs.PostDTO;
import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.repositories.PostRepository;
import com.example.spring_advanced.services.PostRetrofitServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class PostMockUnitTest {
    private PostRepository mockRepository = Mockito.mock(PostRepository.class);
    private ModelMapper mockModelMapper = Mockito.mock(ModelMapper.class);
    private PostRetrofitServiceImpl postRetrofitServiceImpl = new PostRetrofitServiceImpl(mockRepository, mockModelMapper);

    @Test
    public void findByIdTest () throws Exception {
        Post post = new Post( 1L, 1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\n" +
                " suscipit recusandae consequuntur expedita et cum\n" +
                " reprehenderit molestiae ut ut quas totam\n" +
                " nostrum rerum est autem sunt rem eveniet architecto");
        Mockito.when(mockRepository.findById(1L)).thenReturn(Optional.of(post));
        PostDTO postDTO = new PostDTO( "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\n" +
                " suscipit recusandae consequuntur expedita et cum\n" +
                " reprehenderit molestiae ut ut quas totam\n" +
                " nostrum rerum est autem sunt rem eveniet architecto");
        Mockito.when(mockModelMapper.map(post, PostDTO.class)).thenReturn(postDTO);

        PostDTO postResultDTO = postRetrofitServiceImpl.findPostById(1L);

        Assertions.assertEquals(postDTO, postResultDTO);
        Mockito.verify(mockRepository).findById(1L);
    }

}
