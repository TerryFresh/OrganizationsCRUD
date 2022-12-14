package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchService branchService;

    @GetMapping("/getBranch/{id}")
    public Branch showBranch(@PathVariable(value = "id") Long id){
        return branchService.getBranch(id);
    }

    @GetMapping("/showAllBranch")
    public List<Branch> showAllBranch(){
        return branchService.getAllBranch();
    }

    @PostMapping("/saveBranch")
    public void saveBranch(@RequestBody Branch branch){
        branchService.saveBranch(branch);
    }

    @PutMapping("/updateBranch/{id}")
    public void updateBranch(@RequestBody Branch branch, @PathVariable Long id){
        branchService.updateBranch(branch, id);
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
