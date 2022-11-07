package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/updateBranch")
    public void updateBranch(@RequestBody Branch branch){
        branchService.saveBranch(branch);
    }

    @PostMapping("/deleteBranch/{id}")
    public void deleteBranch(@PathVariable(value = "id") Long id){
        branchService.deleteBranch(id);
    }
}
