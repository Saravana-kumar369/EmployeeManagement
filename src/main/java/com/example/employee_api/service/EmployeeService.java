
package com.example.employee_api.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee_api.Entity.Employee;
import com.example.employee_api.Repository.EmployeeRepository;
import com.example.employee_api.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {

     private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public Employee getEmployeeDetails(int id) {
        // return employeeRepository.findById(id).orElse(null);
        // use to throw an exception if employee not found the above line will return null and makes succeed status in controller.    
        // return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        // reduces repeated code and makes it more readable by creating a custom exception class EmployeeNotFoundException.
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }
    public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
}
}
