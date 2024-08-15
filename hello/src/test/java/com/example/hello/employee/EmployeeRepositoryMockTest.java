package com.example.hello.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryMockTest {

    @Autowired
    private EmployeeRepository repository;
    
    @Test
    @DisplayName("Database มีปัญหา โดยโยน RuntimeException ออกมา")
    public void case06() {
        repository.findById(3);
    }

}