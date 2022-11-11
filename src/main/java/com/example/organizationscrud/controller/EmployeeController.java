package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showEmployee/{id}")
    public Employee showEmployee(@PathVariable(value = "id") Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/showAllEmployee")
    public List<Employee> showAllEmployees(){
         return employeeService.getAllEmployees();
    }

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        employeeService.saveEmployee(employee);
        return employeeService.getEmployee(employee.getId());
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable(value = "id") Long id){
        employeeService.deleteEmployee(id);
    }
}
