package com.example.hello.employee;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService2 {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void doProcess(){
//        employeeRepository.deleteAll();
    }

}
