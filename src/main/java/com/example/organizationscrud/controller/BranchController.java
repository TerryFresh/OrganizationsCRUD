package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/getBranch/{id}")
    public Branch showBranch(@PathVariable(value = "id") Long id){
        return branchService.getBranch(id);
    }

    @GetMapping("/showAllBranch")
    public List<Branch> showAllBranch(){
        return branchService.getAllBranch();
    }

    @PostMapping("/saveBranch")
    public Branch saveBranch(@RequestBody Branch branch){
        return branchService.saveBranch(branch);
    }

    @PutMapping("/updateBranch/{id}")
    public Branch updateBranch(@RequestBody Branch branch, @PathVariable Long id){
        return branchService.updateBranch(branch, id);
    }

    @DeleteMapping("/deleteBranch/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBranch(@PathVariable(value = "id") Long id){
        branchService.deleteBranch(id);
    }

    @PutMapping("/setBranchInOrganization/{branchId}")
    public void setBranchInOrganization(@PathVariable Long branchId, @RequestParam Long organizationId){
        branchService.setBranchInOrganization(branchId, organizationId);
    }
}
