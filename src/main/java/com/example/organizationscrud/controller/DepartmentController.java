package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Department;
import com.example.organizationscrud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/getDepartment/{id}")
    public Department showEmployee(@PathVariable(value = "id") Long id){
        return departmentService.getDepartment(id);
    }

    @GetMapping("/showAllDepartment")
    public List<Department> showAllCartel(){
        return departmentService.getAllDepartment();
    }

    @PostMapping("/saveDepartment")
    public void saveDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
    }

    @PutMapping("/updateDepartment/{id}")
    public void updateDepartment(@RequestBody Department department, @PathVariable Long id){
        departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable(value = "id") Long id){
        departmentService.deleteDepartment(id);
    }

    @PutMapping("/setDepartmentInOrganization/{departmentId}")
    public void setDepartmentInOrganization(@PathVariable Long departmentId, @RequestParam Long organizationId){
        departmentService.setDepartmentInOrganization(departmentId, organizationId);
    }

    @PutMapping("/setDepartmentInBranch/{departmentId}")
    public void setDepartmentInBranch(@PathVariable Long departmentId, @RequestParam Long branchId){
        departmentService.setDepartmentInBranch(departmentId, branchId);
    }

    @PutMapping("/setDisableDepartmentBranch/{departmentId}")
    public void setDisableDepartmentBranch(@PathVariable Long departmentId){
        departmentService.setDisableDepartmentBranch(departmentId);
    }

    @PutMapping("/setSubDepartmentInDepartment/{subDepartmentId}")
    public void setSubDepartmentInDepartment(@PathVariable Long subDepartmentId, @RequestParam Long departmentId){
        departmentService.setSubDepartmentInDepartment(subDepartmentId, departmentId);
    }

}
