package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Department;
import com.example.organizationscrud.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepo departmentRepo;

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
    public void deleteDepartment(Long id) {
        departmentRepo.deleteById(id);
    }
}
