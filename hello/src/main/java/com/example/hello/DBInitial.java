package com.example.hello;

import com.example.hello.employee.Employee;
import com.example.hello.employee.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBInitial {

    @Autowired
    private EmployeeRepository repository;

    @PostConstruct
    public void initialData(){
        repository.saveAndFlush(new Employee("F2", "L2", "E2", 10));
        repository.saveAndFlush(new Employee("F3", "L3", "E3", 20));
    }

}
