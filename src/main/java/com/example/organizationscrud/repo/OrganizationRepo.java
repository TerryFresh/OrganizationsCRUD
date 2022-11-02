package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends CrudRepository<Organization, Long> {
}
