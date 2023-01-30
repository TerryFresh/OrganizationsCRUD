package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {
}
