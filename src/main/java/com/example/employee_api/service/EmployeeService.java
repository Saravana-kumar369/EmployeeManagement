
package com.example.employee_api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee_api.DTO.EmployeeRequest;
import com.example.employee_api.DTO.EmployeeResponse;
import com.example.employee_api.Entity.Employee;
import com.example.employee_api.Repository.EmployeeRepository;
import com.example.employee_api.exception.EmployeeNotFoundException;

import jakarta.transaction.Transactional;

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
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());    
        employee.setDepartment(employeeRequest.getDepartment());
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeResponse(
            savedEmployee.getEmployeeId(),
            savedEmployee.getName(),
            savedEmployee.getDepartment()
        );
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee updateEmployee(int id, EmployeeRequest request) {
        // TODO Auto-generated method stub
        Employee existingEmployee = getEmployeeDetails(id);
        existingEmployee.setName(request.getName());
        existingEmployee.setDepartment(request.getDepartment());
        return existingEmployee;
    }

    @Transactional
    public void deleteEmployee(int id) {
        Employee existingEmployee = getEmployeeDetails(id);
        employeeRepository.delete(existingEmployee);
    }
}
