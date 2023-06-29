package com.example.spring_advanced;

import com.example.spring_advanced.repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.swing.text.html.parser.Entity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class PostIntegrationTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    public void name () {
       // assertThat(postRepository.findAll())
                //.extracting(Entity::getName)
               // .containsExactly(
               //         "Name 1",
                //        "Name 2"
              //  );
    }
}
