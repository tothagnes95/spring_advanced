package com.example.spring_advanced;

import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringAdvancedApplication.class)
public class PostInMemoryDBUnitTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void savePostToRepository_AndGive_OK() {
        Post genericEntity = postRepository
                .save(new Post(1L, 1, 1, "test", "test"));
        Post foundEntity = postRepository
                .findById(genericEntity.getPostId()).get();

        assertNotNull(foundEntity);
        assertEquals(genericEntity.getTitle(), foundEntity.getTitle());
        assertEquals(genericEntity.getId(), foundEntity.getId());
    }
}
