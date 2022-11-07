package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Organization;
import com.example.organizationscrud.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/getOrganization/{id}")
    public Organization getOrganization(@PathVariable(value = "id") Long id){
        return organizationService.getOrganization(id);
    }

    @GetMapping("/showAllOrganization")
    public List<Organization> showAllEmployees(){
        return organizationService.getAllOrganization();
    }

    @PostMapping("/saveOrganization")
    public void saveOrganization(@RequestBody Organization organization){
        organizationService.saveOrganization(organization);
    }

    @PutMapping("/updateOrganization")
    public void updateOrganization(@RequestBody Organization organization){
        organizationService.saveOrganization(organization);
    }

    @PostMapping("/deleteOrganization/{id}")
    public void deleteOrganization(@PathVariable(value = "id") Long id){
        organizationService.deleteOrganization(id);
    }

}