package com.example.hello.employee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    @DisplayName("ดึงข้อมูล employee id=1 สำเร็จ")
    public void case04() {
        // Arrange
        Employee e1 = new Employee("f1", "l1", "e1", 30);
        repository.save(e1);
        // Act
        Optional<Employee> result =  repository.findById(1);
        // Assert
        assertTrue(result.isPresent());
        assertEquals("f1", result.get().getFirstName());
    }

    @Test
    @DisplayName("ไม่พบข้อมูล id=2")
    public void case05() {
        // Act
        Optional<Employee> result =  repository.findById(2);
        // Assert
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("การบันทึกซ้ำ")
    public void case07(){
        Employee e1 = new Employee("f1", "l1", "e1", 30);
        assertNull(e1.getId());
        repository.saveAndFlush(e1);
        assertNotNull(e1.getId());
        repository.saveAndFlush(e1);
        assertNotNull(e1.getId());
    }

}