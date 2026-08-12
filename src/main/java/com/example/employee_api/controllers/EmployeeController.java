package com.example.employee_api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public String getEmployee() {
        return "Hello, Employee!";
    }
    
}
