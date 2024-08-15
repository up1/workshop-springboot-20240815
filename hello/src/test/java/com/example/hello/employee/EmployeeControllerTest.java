package com.example.hello.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getById() {
        EmployeeResponse result
                = restTemplate.getForObject("/employee/1", EmployeeResponse.class);
        assertEquals(1, result.getId());
        assertEquals("Somkiat", result.getName());
        assertEquals("xxx@gmail.com", result.getEmail());
    }
}