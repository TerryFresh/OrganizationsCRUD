package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Department;
import com.example.organizationscrud.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    EntityManager entityManager;

    @Autowired
    DepartmentRepo departmentRepo;

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
    public void saveDepartment(Department department) {
        Department newDep = entityManager.merge(department);
        departmentRepo.save(newDep);
    }

    @Override
    @Transactional
    public void deleteDepartment(Long id) {
        Query query = entityManager.createQuery("delete from Department " + "where id =:departmentId");
        query.setParameter("departmentId", id);
        query.executeUpdate();
    }
}
