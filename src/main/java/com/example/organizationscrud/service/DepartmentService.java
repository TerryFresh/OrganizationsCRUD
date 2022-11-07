package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Department;

import java.util.List;

public interface DepartmentService {

    public Department getDepartment(Long id);

    public List<Department> getAllDepartment();

    public void saveDepartment(Department department);

    public void deleteDepartment(Long id);

}
