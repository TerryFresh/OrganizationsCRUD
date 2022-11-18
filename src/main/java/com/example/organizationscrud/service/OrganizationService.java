package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Organization;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface OrganizationService {

    public Organization getOrganization(Long id);

    public List<Organization> getAllOrganization();

    public void saveOrganization(Organization organization);

    public void  updateOrganization(Organization organization, Long id);

    public void deleteOrganization(Long id);

    public void setOrganizationInCartel(Long cartelId, Long organizationId);

    public String getStructureInfoForEmployee(Long employeeId) throws IOException;

}
