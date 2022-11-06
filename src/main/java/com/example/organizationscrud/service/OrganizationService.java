package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Organization;

import java.util.List;

public interface OrganizationService {

    public Organization getOrganization(Long id);

    public List<Organization> getAllOrganization();

    public void saveOrganization(Organization organization);

    public void deleteOrganization(Long id);
}
