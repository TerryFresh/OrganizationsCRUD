package com.example.organizationscrud.service;

import com.example.organizationscrud.model.*;
import com.example.organizationscrud.repo.BranchRepo;
import com.example.organizationscrud.repo.DepartmentRepo;
import com.example.organizationscrud.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepo departmentRepo;

    private final OrganizationRepo organizationRepo;

    private final BranchRepo branchRepo;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepo departmentRepo, OrganizationRepo organizationRepo, BranchRepo branchRepo) {
        this.departmentRepo = departmentRepo;
        this.organizationRepo = organizationRepo;
        this.branchRepo = branchRepo;
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    @Transactional
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    @Transactional
    public Department updateDepartment(Department department, Long id) {
        Department newDepartment = departmentRepo.findById(id).orElseThrow();
        newDepartment.setName(department.getName());
        return departmentRepo.save(newDepartment);
    }

    @Override
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
//        if (departmentRepo.findById(departmentId).orElseThrow().getOrganization().equals(branchRepo.findById(branchId).orElseThrow().getOrganization())){
        if (departmentRepo.findById(departmentId).orElseThrow().getOrganization() == branchRepo.findById(branchId).orElseThrow().getOrganization()){
            Department department = departmentRepo.findById(departmentId).orElseThrow();
            department.setBranch(branchRepo.findById(branchId).orElseThrow());
            departmentRepo.save(department);
        }
    }

    @Override
    public void setDisableDepartmentBranch(Long departmentId) {
        Department department = departmentRepo.findById(departmentId).orElseThrow();
        department.setBranch(null);
        departmentRepo.save(department);
    }

    @Override
    public void setSubDepartmentInDepartment(Long subDepartmentId, Long departmentId) {
        if (departmentRepo.findById(departmentId).orElseThrow().getOrganization().equals(departmentRepo.findById(subDepartmentId).orElseThrow().getOrganization())){
            Department subDepartment = departmentRepo.findById(subDepartmentId).orElseThrow();
            subDepartment.setParentDepartment(departmentRepo.findById(departmentId).orElseThrow());
            departmentRepo.save(subDepartment);
        }
    }
}
