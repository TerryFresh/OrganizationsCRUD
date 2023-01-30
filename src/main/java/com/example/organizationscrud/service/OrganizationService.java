package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Organization;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface OrganizationService {

    Organization getOrganization(Long id);

    List<Organization> getAllOrganization();

    void saveOrganization(Organization organization);

    void updateOrganization(Organization organization, Long id);

    void deleteOrganization(Long id);

    void setOrganizationInCartel(Long cartelId, Long organizationId);

    String getStructureInfoForEmployee(Long employeeId) throws IOException;

}
