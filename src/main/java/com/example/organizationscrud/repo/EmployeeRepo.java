package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
