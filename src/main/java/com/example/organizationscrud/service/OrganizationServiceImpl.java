package com.example.organizationscrud.service;

import com.example.organizationscrud.dto.DepartmentDTO;
import com.example.organizationscrud.dto.OrganizationDTO;
import com.example.organizationscrud.model.Department;
import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.model.Organization;
import com.example.organizationscrud.repo.CartelRepo;
import com.example.organizationscrud.repo.DepartmentRepo;
import com.example.organizationscrud.repo.EmployeeRepo;
import com.example.organizationscrud.repo.OrganizationRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepo organizationRepo;

    @Autowired
    CartelRepo cartelRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Organization getOrganization(Long id) {
        return organizationRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepo.findAll();
    }

    @Override
    @Transactional
    public void saveOrganization(Organization organization) {
        organizationRepo.save(organization);
    }

    @Override
    @Transactional
    public void updateOrganization(Organization organization, Long id) {
        Organization newOrganization = organizationRepo.findById(id).orElseThrow();
        newOrganization.setName(organization.getName());
        organizationRepo.save(newOrganization);
    }

    @Override
    @Transactional
    public void deleteOrganization(Long id) {
        organizationRepo.deleteById(id);
    }

    @Override
    public void setOrganizationInCartel(Long cartelId, Long organizationId) {
        Organization organization = organizationRepo.findById(organizationId).orElseThrow();
        organization.setCartel(cartelRepo.findById(cartelId).orElseThrow());
        organizationRepo.save(organization);
    }

    @Override
    public String getStructureInfoForEmployee(Long employeeId) throws IOException {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow();

        if (employee.getHeadOfDepartment() != null) {
            ArrayList<Department> arrayList = new ArrayList<>(employee.getOrganization().getDepartment());
            DepartmentDTO departmentDTO = new DepartmentDTO();
            List<Object> list = new ArrayList<>();

            for (int i = 0; i < arrayList.size(); i++) {
                if (!Objects.equals(employee.getDepartment().getId(), arrayList.get(i).getId())) {
                    departmentDTO.setId(arrayList.get(i).getId());
                    departmentDTO.setName(arrayList.get(i).getName());
                    departmentDTO.setEmployeeHead(arrayList.get(i).getEmployeeHead().getId());
                    departmentDTO.setBranch(arrayList.get(i).getBranch());
                    list.add(departmentDTO);
                }
            }
            list.add(employee.getDepartment());

            OrganizationDTO organizationDTO = new OrganizationDTO();
            organizationDTO.setId(employee.getOrganization().getId());
            organizationDTO.setName(employee.getOrganization().getName());
            organizationDTO.setDepartment(list);

            String json = objectMapper.writeValueAsString(organizationDTO);
            return json;
        } else return objectMapper.writeValueAsString(employee.getDepartment());
    }
}





















