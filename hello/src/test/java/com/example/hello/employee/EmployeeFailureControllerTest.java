package com.example.hello.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ProblemDetail;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeFailureControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("ไม่พบข้อมูลของพนักงาน id=5")
    void case02() {
        ProblemDetail result
                = restTemplate.getForObject("/employee/5", ProblemDetail.class);
        assertEquals(404, result.getStatus());
        assertEquals("Employee not found", result.getDetail());
        assertEquals("/employee/5", result.getInstance().toString());
    }

    @Test
    @DisplayName("ข้อมูล id ไม่ใช่ตัวเลข")
    void case03() {
        ProblemDetail result
                = restTemplate.getForObject("/employee/xyz", ProblemDetail.class);
        assertEquals(400, result.getStatus());
        assertEquals("Failed to convert 'id' with value: 'xyz'", result.getDetail());
        assertEquals("/employee/xyz", result.getInstance().toString());
    }
}