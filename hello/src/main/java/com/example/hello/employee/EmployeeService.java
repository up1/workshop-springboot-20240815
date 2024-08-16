package com.example.hello.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MyService2 myService2;

    public EmployeeService(EmployeeRepository employeeRepository, MyService2 myService2) {
        this.employeeRepository = employeeRepository;
        this.myService2 = myService2;
    }

    @Transactional(dontRollbackOn = EmployeeNotFoundException.class)
    public EmployeeResponse getById(int id) {
        myService2.doProcess();
        employeeRepository.save(new Employee());
        employeeRepository.save(new Employee());
        // Call external api
        Optional<Employee> result =  employeeRepository.findById(id);
        if (result.isEmpty()) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        Employee employee = result.get();
        String name = employee.getFirstName() + " " + employee.getLastName();
        String email = employee.getEmail();
        return new EmployeeResponse(id, name, email);
    }
}
