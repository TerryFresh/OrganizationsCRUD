package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.repo.BranchRepo;
import com.example.organizationscrud.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService{

    private final BranchRepo branchRepo;

    private final OrganizationRepo organizationRepo;

    @Autowired
    public BranchServiceImpl(BranchRepo branchRepo, OrganizationRepo organizationRepo) {
        this.branchRepo = branchRepo;
        this.organizationRepo = organizationRepo;
    }

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
    public Branch saveBranch(Branch branch) {
        return branchRepo.save(branch);
    }

    @Override
    @Transactional
    public Branch updateBranch(Branch branch, Long id) {
        Branch newBranch = branchRepo.findById(id).orElseThrow();
        newBranch.setName(branch.getName());
        return branchRepo.save(newBranch);
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepo.deleteById(id);
    }

    @Override
    public void setBranchInOrganization(Long branchId, Long organizationId) {
        Branch branch = branchRepo.findById(branchId).orElseThrow();
        branch.setOrganization(organizationRepo.findById(organizationId).orElseThrow());
        branchRepo.save(branch);
    }
}