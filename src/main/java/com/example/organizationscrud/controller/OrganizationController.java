package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Department;
import com.example.organizationscrud.model.Organization;
import com.example.organizationscrud.service.CartelService;
import com.example.organizationscrud.service.OrganizationService;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private CartelService cartelService;

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

    @PutMapping("/updateOrganization/{id}")
    public void updateOrganization(@RequestBody Organization organization, @PathVariable Long id){
        organizationService.saveOrganization(organization);
    }

    @DeleteMapping("/deleteOrganization/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable(value = "id") Long id){
        organizationService.deleteOrganization(id);
    }

    @PutMapping("/setOrganizationInCartel")
    public void setOrganizationInCartel(@RequestParam Long cartelId, @RequestParam Long organizationId){
        organizationService.setOrganizationInCartel(cartelId, organizationId);
    }

    @GetMapping("/getStructureInfoForEmployee/{id}")
    public String getStructureInfoForEmployee(@PathVariable(value = "id") Long id) throws IOException {
        return organizationService.getStructureInfoForEmployee(id);
    }
}
