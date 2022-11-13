package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Branch;

import java.util.List;

public interface BranchService {

    public Branch getBranch(Long id);

    public List<Branch> getAllBranch();

    public void saveBranch(Branch branch);

    public void  updateBranch(Branch branch, Long id);

    public void deleteBranch(Long id);



}
