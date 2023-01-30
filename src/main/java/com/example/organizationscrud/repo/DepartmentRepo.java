package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
