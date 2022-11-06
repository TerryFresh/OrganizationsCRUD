package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployee(Long id);
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public void deleteEmployee(Long id);
}
