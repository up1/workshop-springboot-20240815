package com.example.hello.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceUnitTest {

    @Mock
    private MyService2 myService2;
    @Mock
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("try service testing with success")
    void case01() {
        // Arrange
        Employee e1 = new Employee(1, "X", "Y", "xxx@xxx.com", 40);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(e1));
        EmployeeService employeeService = new EmployeeService(employeeRepository, myService2);
        // Act
        EmployeeResponse response = employeeService.getById(1);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("X Y", response.getName());
        assertEquals("xxx@xxx.com", response.getEmail());
    }
}