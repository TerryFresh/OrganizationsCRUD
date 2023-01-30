package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BranchRepo extends JpaRepository<Branch, Long> {

}
