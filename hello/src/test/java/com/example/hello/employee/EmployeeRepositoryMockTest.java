package com.example.hello.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class EmployeeRepositoryMockTest {

    @MockBean
    private EmployeeRepository repository;

    @Test
    @DisplayName("Database มีปัญหา โดยโยน RuntimeException ออกมา")
    public void case06() {
        // Arrange
        when(repository.findById(3)).thenThrow(new RuntimeException());
        // Act and Assert
        assertThrows(RuntimeException.class, () -> {
            repository.findById(3);
        });
    }

}