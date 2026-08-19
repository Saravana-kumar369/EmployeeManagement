package com.example.employee_api.DTO;

public class EmployeeResponse {

    private int employeeId;
    private String name;
    private String department;

    public EmployeeResponse(int employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}