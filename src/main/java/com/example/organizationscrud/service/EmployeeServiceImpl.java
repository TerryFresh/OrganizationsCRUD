package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee, Long id) {
        Employee newEmployee = employeeRepo.findById(id).orElseThrow();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setSecondName(employee.getSecondName());
        employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
