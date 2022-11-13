package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.model.Department;
import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.repo.BranchRepo;
import com.example.organizationscrud.repo.DepartmentRepo;
import com.example.organizationscrud.repo.EmployeeRepo;
import com.example.organizationscrud.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    OrganizationRepo organizationRepo;

    @Autowired
    BranchRepo branchRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Department getDepartment(Long id) {
        return departmentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    @Transactional
    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    @Transactional
    public void updateDepartment(Department department, Long id) {
        Department newDepartment = departmentRepo.findById(id).orElseThrow();
        newDepartment.setName(department.getName());
        departmentRepo.save(newDepartment);
    }

    @Override
    @Transactional
    public void deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
    }

    @Override
    public void setDepartmentInOrganization(Long departmentId, Long organizationId) {
        Department department = departmentRepo.findById(departmentId).orElseThrow();
        department.setOrganization(organizationRepo.findById(organizationId).orElseThrow());
        departmentRepo.save(department);
    }

    @Override
    public void setDepartmentInBranch(Long departmentId, Long branchId) {
        Department department = departmentRepo.findById(departmentId).orElseThrow();
        department.setBranch(branchRepo.findById(branchId).orElseThrow());
        departmentRepo.save(department);
    }

    @Override
    public void setSubDepartmentInDepartment(Long subDepartmentId, Long departmentId) {
        Department subDepartment = departmentRepo.findById(subDepartmentId).orElseThrow();
        subDepartment.setParentDepartment(departmentRepo.findById(departmentId).orElseThrow());
        departmentRepo.save(subDepartment);
    }

    @Override
    public void setEmployeeHeadOfDepartment(Long employeeId, Long departmentId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();
        employee.setHeadOfDepartment(departmentRepo.findById(departmentId).orElseThrow());
        employeeRepo.save(employee);
    }
}
