package com.example.spring_advanced;

import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.repositories.PostRepository;
import com.example.spring_advanced.services.PostRetrofitServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class PostUnitTest {
    private PostRepository mockRepository = Mockito.mock(PostRepository.class);
    private PostRetrofitServiceImpl postRetrofitServiceImpl = new PostRetrofitServiceImpl(mockRepository);

    //Unit test

    @Test
    public void findByIdTest () {
        Post post = new Post(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "quia et suscipit\n" +
                " suscipit recusandae consequuntur expedita et cum\n" +
                " reprehenderit molestiae ut ut quas totam\n" +
                " nostrum rerum est autem sunt rem eveniet architecto");
        Mockito.when(mockRepository.findById(1L)).thenReturn(Optional.of(post));

        Post postResult = postRetrofitServiceImpl.findPostById(1L);

        Assertions.assertEquals(post, postResult);
        Mockito.verify(mockRepository).findById(1L);
    }

}
