package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    OrganizationService organizationService;
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
        branchRepo.save(branch);
    }

    @Override
    @Transactional
    public void updateBranch(Branch branch, Long id) {
        Branch newBranch = branchRepo.findById(id).orElseThrow();
        newBranch.setName(branch.getName());
        branchRepo.save(newBranch);
    }

    @Override
    @Transactional
    public void deleteBranch(Long id) {
        branchRepo.deleteById(id);
    }
}