package com.example.spring_advanced;

import com.example.spring_advanced.models.Post;
import com.example.spring_advanced.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PostIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void listPostsTest () throws Exception {
        postRepository.save(new Post(1L, 1, 1, "test", "test"));
        mockMvc.perform(MockMvcRequestBuilders.get("/listPosts")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiYWdpIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY4Nzk0MzU5MiwiZXhwIjoxNjg3OTQ0MTkyfQ.qKjh2KXZy8ag_gqponBKL38TdQBGeNBMq9gB9aBaOOy4FUFmc2rydNV2vZa79ti__eO5rxf5z1CFhkBjq7U1SA"))
                .andExpect(content().json(
                        "    [{\n" +
                                "        \"postId\": 1,\n" +
                                "        \"userId\": 1,\n" +
                                "        \"id\": 1,\n" +
                                "        \"title\": \"test\",\n" +
                                "        \"body\": \"test\"\n" +
                                "    }]\n"
                ))
                .andExpect(status().isOk());
    }
}
