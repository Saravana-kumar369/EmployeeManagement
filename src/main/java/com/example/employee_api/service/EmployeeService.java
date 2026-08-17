
package com.example.employee_api.service;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee_api.Entity.Employee;
import com.example.employee_api.Repository.EmployeeRepository;

@Service
public class EmployeeService {

     private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public Employee getEmployeeDetails(int id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee createEmployee(Employee employee) {
    return employeeRepository.save(employee);
}
}
