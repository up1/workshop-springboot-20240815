package com.example.hello.employee;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeRepository repository;

    @AfterEach
    public void cleanup(){
        repository.deleteAll();
        repository.flush();
    }

    @Test
    @DisplayName("ดึงข้อมูลของพนักงานรหัส 1 สำเร็จ")
    void case01() {
        // Arrange
        Employee e1 = new Employee("Somkiat", "l1", "xxx@gmail.com", 30);
        repository.save(e1);
        // Act
        EmployeeResponse result
                = restTemplate.getForObject("/employee/1", EmployeeResponse.class);
        assertEquals(1, result.getId());
        assertEquals("Somkiat", result.getName());
        assertEquals("xxx@gmail.com", result.getEmail());
    }

    @Test
    @DisplayName("Success to create a new employee")
    void case02() {
        // Arrange
        EmployeeCreateRequest request = new EmployeeCreateRequest();
        request.setFirst_name("Somkiat");
        request.setLast_name("Puisungnoen");
        // Act
        ResponseEntity<EmployeeResponse> result
                = restTemplate.postForEntity("/employee", request, EmployeeResponse.class);
        assertEquals("Somkiat Puisungnoen", result.getBody().getName());
    }
}