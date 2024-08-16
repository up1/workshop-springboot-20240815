package com.example.hello.posts;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Tag("integration")
class PostGatewayIntegrationTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    void getById() {
        // Act
        Optional<PostResponse> result =  postGateway.getById(1);
        // Assert
        assertEquals(1, result.get().getId());
        assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", result.get().getTitle());
    }
}