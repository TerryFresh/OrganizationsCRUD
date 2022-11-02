package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends CrudRepository <Branch, Long> {

}
