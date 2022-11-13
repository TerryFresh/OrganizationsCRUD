package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.model.Organization;
import com.example.organizationscrud.repo.CartelRepo;
import com.example.organizationscrud.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepo organizationRepo;

    @Autowired
    CartelRepo cartelRepo;

    @Override
    public Organization getOrganization(Long id) {
        return organizationRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepo.findAll();
    }

    @Override
    @Transactional
    public void saveOrganization(Organization organization) {
        organizationRepo.save(organization);
    }

    @Override
    @Transactional
    public void updateOrganization(Organization organization, Long id) {
        Organization newOrganization = organizationRepo.findById(id).orElseThrow();
        newOrganization.setName(organization.getName());
        organizationRepo.save(newOrganization);
    }

    @Override
    @Transactional
    public void deleteOrganization(Long id) {
        organizationRepo.deleteById(id);
    }

    @Override
    public void setOrganizationInCartel(Long cartelId, Long organizationId) {
        Organization organization = organizationRepo.findById(organizationId).orElseThrow();
        organization.setCartel(cartelRepo.findById(cartelId).orElseThrow());
        organizationRepo.save(organization);
    }


}
