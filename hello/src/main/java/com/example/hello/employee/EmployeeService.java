package com.example.hello.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeResponse getById(int id) {
        Optional<Employee> result =  employeeRepository.findById(id);
        if (result.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        Employee employee = result.get();
        String name = employee.getFirstName();
        String email = employee.getEmail();
        return new EmployeeResponse(id, name, email);
    }
}
