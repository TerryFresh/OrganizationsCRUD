package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Employee;
import com.example.organizationscrud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployee/{id}")
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
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable(value = "id") Long id){
        employeeService.deleteEmployee(id);
    }


    @PutMapping("/setEmployeeHeadOfDepartment/{id}")
    public void setEmployeeHeadOfDepartment(@PathVariable Long id){
        employeeService.setEmployeeHeadOfDepartment(id);
    }

    @PutMapping("/setDisableHeadOfDepartment/{id}")
    public void setDisableHeadOfDepartment(@PathVariable Long id){
        employeeService.setDisableHeadOfDepartment(id);
    }

    @PutMapping("/setEmployeeInDepartment/{employeeId}")
    public void setEmployeeInDepartment(@PathVariable Long employeeId, @RequestParam Long departmentId){
        employeeService.setEmployeeInDepartment(employeeId, departmentId);
    }

    @PutMapping("/setEmployeeChangedDepartment/{employeeId}")
    public void setEmployeeChangedDepartment(@PathVariable Long employeeId, @RequestParam Long departmentId){
        employeeService.setEmployeeChangedDepartment(employeeId, departmentId);
    }
}
