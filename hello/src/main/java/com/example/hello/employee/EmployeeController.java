package com.example.hello.employee;

import com.example.hello.aop.LogExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @LogExecutionTime
    @GetMapping("/employee/{id}")
    // employee/1
    public EmployeeResponse getById(@PathVariable int id) {
        logger.info("Handling getById request");
        EmployeeResponse employeeResponse = employeeService.getById(id);
        return employeeResponse;
    }

    // employee?id=1
    @GetMapping("/employee")
    public EmployeeResponse getById2(@RequestParam(defaultValue = "100") int id){
        return new EmployeeResponse(id, "", "");
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeResponse> createNewEmployee(
            @RequestBody EmployeeCreateRequest request){
        EmployeeResponse body = new EmployeeResponse();
        body.setName("%s %s".formatted(request.getFirst_name(), request.getLast_name()));
        ResponseEntity<EmployeeResponse> response
                = new ResponseEntity<>(body, HttpStatusCode.valueOf(201));
        return response;
    }

}
