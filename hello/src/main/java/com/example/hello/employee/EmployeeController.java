package com.example.hello.employee;

import com.example.hello.aop.LogExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @LogExecutionTime
    @GetMapping("/employee/{id}")
    public EmployeeResponse getById(@PathVariable int id) {
        logger.info("Handling getById request");
        EmployeeResponse employeeResponse = employeeService.getById(id);
        return employeeResponse;
    }

}
