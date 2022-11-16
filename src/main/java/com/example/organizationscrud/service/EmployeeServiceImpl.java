package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.repo.DepartmentRepo;
import com.example.organizationscrud.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

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

    @Override
    public void setEmployeeHeadOfDepartment(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        setDisableHeadOfDepartment(employee.getDepartment().getId());
        employee.setHeadOfDepartment(employee.getDepartment());
        departmentRepo.findById(employee.getDepartment().getId()).orElseThrow().setEmployeeHead(employee);
        employeeRepo.save(employee);
    }

    @Override
    public void setDisableHeadOfDepartment(Long departmentId) {
        Employee employee = employeeRepo.findById(departmentRepo.findById(departmentId).orElseThrow().getEmployeeHead().getId()).orElseThrow();
        employee.setHeadOfDepartment(null);
        employeeRepo.save(employee);
    }

    @Override
    public void setEmployeeInDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        employee.setDepartment(departmentRepo.findById(departmentId).orElseThrow());
        employee.setOrganization(departmentRepo.findById(departmentId).orElseThrow().getOrganization());
        employeeRepo.save(employee);
    }

    @Override
    public void setEmployeeChangedDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        if (departmentRepo.findById(departmentId).orElseThrow().getOrganization().equals(employee.getOrganization())) {
            employee.setDepartment(departmentRepo.findById(departmentId).orElseThrow());
            employeeRepo.save(employee);
        } else throw new RuntimeException(); //Поменять на нормальную ошибку
    }
}
