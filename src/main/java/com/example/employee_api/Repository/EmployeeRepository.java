package com.example.employee_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_api.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    
}