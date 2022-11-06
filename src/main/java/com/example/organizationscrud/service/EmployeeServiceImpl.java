package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    EntityManager entityManager;

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
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        Query query = entityManager.createQuery("delete from Employee " + "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
