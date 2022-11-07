package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Organization;
import com.example.organizationscrud.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    OrganizationRepo organizationRepo;

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
        Organization newOrg = entityManager.merge(organization);
        organization.setId(newOrg.getId());
    }

    @Override
    @Transactional
    public void deleteOrganization(Long id) {
        Query query = entityManager.createQuery("delete from Organization " + "where id =:organizationId");
        query.setParameter("organizationId", id);
        query.executeUpdate();
    }
}
