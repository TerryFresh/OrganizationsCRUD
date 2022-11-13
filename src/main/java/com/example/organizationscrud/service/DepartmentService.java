package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.model.Department;
import com.example.organizationscrud.model.Organization;

import java.util.List;

public interface DepartmentService {

    public Department getDepartment(Long id);

    public List<Department> getAllDepartment();

    public void saveDepartment(Department department);

    public void  updateDepartment(Department department, Long id);

    public void deleteDepartment(Long id);

    public void setDepartmentInOrganization(Long departmentId, Long organizationId);

    public void setDepartmentInBranch(Long departmentId, Long branchId);

    public void setSubDepartmentInDepartment(Long subDepartmentId, Long departmentId);

    public void setEmployeeHeadOfDepartment(Long employeeId, Long departmentId);

}
