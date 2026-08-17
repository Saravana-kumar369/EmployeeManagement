package com.example.employee_api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_api.Entity.Employee;
import com.example.employee_api.service.EmployeeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class EmployeeController {

    EmployeeService employeeService;
    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // @GetMapping("/employees/{id}")
    // public ResponseEntity<String> getEmployee(@PathVariable int id) {
    //     return employeeService.getEmployeeDetails(id);
    // }
//     @GetMapping("/employees")
// public String getEmployees(@RequestParam(defaultValue = "all") String department) {
//     return "Employees in department: " + department;
// }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployeeDetails(id);

        return ResponseEntity.ok(employee);
    }
    // @PostMapping("/employees")
    // public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
    //     return ResponseEntity
    //            .status(HttpStatus.CREATED)
    //            .body("Employee created: " + employee.getName());
    // }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee) {

        Employee savedEmployee = employeeService.createEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }
}
