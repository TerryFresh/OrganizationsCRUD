package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployee(Long id);

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public void updateEmployee(Employee employee, Long id);

    public void deleteEmployee(Long id);

    public void setEmployeeHeadOfDepartment(Long employeeId);

    public void setDisableHeadOfDepartment(Long departmentId);

    public void setEmployeeInDepartment(Long employeeId, Long departmentId);

    public void setEmployeeChangedDepartment(Long employeeId, Long departmentId);
}
