package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);

    void setEmployeeHeadOfDepartment(Long employeeId);

    void setDisableHeadOfDepartment(Long departmentId);

    void setEmployeeInDepartment(Long employeeId, Long departmentId);

    void setEmployeeChangedDepartment(Long employeeId, Long departmentId);
}
