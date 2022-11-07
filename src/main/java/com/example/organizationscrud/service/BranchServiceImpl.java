package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    EntityManager entityManager;

    @Autowired
    BranchRepo branchRepo;

    @Override
    public Branch getBranch(Long id) {
        return branchRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Branch> getAllBranch() {
        return branchRepo.findAll();
    }

    @Override
    @Transactional
    public void saveBranch(Branch branch) {
        Branch newBranch = entityManager.merge(branch);
        branchRepo.save(newBranch);
    }

    @Override
    @Transactional
    public void deleteBranch(Long id) {
        Query query = entityManager.createQuery("delete from Branch " + "where id =:branchId");
        query.setParameter("branchId", id);
        query.executeUpdate();
    }
}