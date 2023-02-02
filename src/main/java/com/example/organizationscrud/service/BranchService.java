package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Branch;

import java.util.List;

public interface BranchService {

    Branch getBranch(Long id);

    List<Branch> getAllBranch();

    Branch saveBranch(Branch branch);

    Branch updateBranch(Branch branch, Long id);

    void deleteBranch(Long id);

    void setBranchInOrganization(Long branchId, Long organizationId);
}
