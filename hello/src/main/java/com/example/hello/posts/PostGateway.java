package com.example.hello.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PostGateway {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<PostResponse> getById(int id){
        PostResponse postResponse = null;
        String url = "https://jsonplaceholder.typicode.com/posts/" + id;
        try {
            postResponse = restTemplate.getForObject(url, PostResponse.class);
        } catch (RestClientException e) {
            return Optional.empty();
        }
        return Optional.of(postResponse);
    }

}
