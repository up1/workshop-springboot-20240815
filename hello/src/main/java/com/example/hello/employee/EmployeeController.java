package com.example.hello.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee/{id}")
    public EmployeeResponse getById(@PathVariable int id) {

        if(id == 5) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        return new EmployeeResponse(id, "Somkiat", "xxx@gmail.com");
    }


}
