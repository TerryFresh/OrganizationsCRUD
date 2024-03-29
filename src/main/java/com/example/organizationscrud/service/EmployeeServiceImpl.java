package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.repo.DepartmentRepo;
import com.example.organizationscrud.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final DepartmentRepo departmentRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

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
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee, Long id) {
        Employee newEmployee = employeeRepo.findById(id).orElseThrow();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setSecondName(employee.getSecondName());
        return employeeRepo.save(newEmployee);
    }

    @Override
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
        try {
            Employee employee = employeeRepo.findById(departmentRepo.findById(departmentId).orElseThrow().getEmployeeHead().getId()).orElseThrow();
            employee.setHeadOfDepartment(null);
            departmentRepo.findById(departmentId).orElseThrow().setEmployeeHead(null);
            employeeRepo.save(employee);
        } catch (NullPointerException e){
            e.getMessage();
        }
    }

    @Override
    public void setEmployeeInDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        if (employee.getHeadOfDepartment() != null){
            setDisableHeadOfDepartment(employee.getDepartment().getId());
        }
        employee.setDepartment(departmentRepo.findById(departmentId).orElseThrow());
        employee.setOrganization(departmentRepo.findById(departmentId).orElseThrow().getOrganization());
        employeeRepo.save(employee);
    }

    @Override
    public void setEmployeeChangedDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        if (departmentRepo.findById(departmentId).orElseThrow().getOrganization().equals(employee.getOrganization())) {
            if (employee.getHeadOfDepartment() != null){
                setDisableHeadOfDepartment(employee.getDepartment().getId());
            }
            employee.setDepartment(departmentRepo.findById(departmentId).orElseThrow());
            employeeRepo.save(employee);
        } else throw new RuntimeException(); //Поменять на нормальную ошибку
    }
}
