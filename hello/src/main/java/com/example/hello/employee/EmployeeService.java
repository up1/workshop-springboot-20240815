package com.example.hello.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public EmployeeResponse getById(int id) {
        if (id == 5) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return new EmployeeResponse(id, "Somkiat", "xxx@gmail.com");
    }
}
