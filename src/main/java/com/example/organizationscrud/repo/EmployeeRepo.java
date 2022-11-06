package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
