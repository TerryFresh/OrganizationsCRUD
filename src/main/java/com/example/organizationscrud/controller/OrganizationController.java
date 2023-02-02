package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Organization;
import com.example.organizationscrud.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/getOrganization/{id}")
    public Organization getOrganization(@PathVariable(value = "id") Long id){
        return organizationService.getOrganization(id);
    }

    @GetMapping("/showAllOrganization")
    public List<Organization> showAllEmployees(){
        return organizationService.getAllOrganization();
    }

    @PostMapping("/saveOrganization")
    public Organization saveOrganization(@RequestBody Organization organization){
        return organizationService.saveOrganization(organization);
    }

    @PutMapping("/updateOrganization/{id}")
    public Organization updateOrganization(@RequestBody Organization organization, @PathVariable Long id){
        return organizationService.updateOrganization(organization, id);
    }

    @DeleteMapping("/deleteOrganization/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable(value = "id") Long id){
        organizationService.deleteOrganization(id);
    }

    @PutMapping("/setOrganizationInCartel/{organizationId}")
    public void setOrganizationInCartel(@PathVariable Long organizationId, @RequestParam Long cartelId){
        organizationService.setOrganizationInCartel(cartelId, organizationId);
    }

    @GetMapping("/getStructureInfoForEmployee/{id}")
    public String getStructureInfoForEmployee(@PathVariable(value = "id") Long id) throws IOException {
        return organizationService.getStructureInfoForEmployee(id);
    }
}
