package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Department;

import java.util.List;

public interface DepartmentService {

    Department getDepartment(Long id);

    List<Department> getAllDepartment();

    Department saveDepartment(Department department);

    Department updateDepartment(Department department, Long id);

    void deleteDepartment(Long id);

    void setDepartmentInOrganization(Long departmentId, Long organizationId);

    void setDisableDepartmentBranch(Long departmentId);

    void setDepartmentInBranch(Long departmentId, Long branchId);

    void setSubDepartmentInDepartment(Long subDepartmentId, Long departmentId);

}
