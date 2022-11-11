package com.example.organizationscrud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //имя депа
    private String name;

    //работники депа
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "department",
            fetch = FetchType.LAZY)
    private List<Employee> employeeOfDepartment;

    //Глава департамента
    @OneToOne
    @JoinColumn(name="head_employee_id")
    private Employee employeeHead;

    //кому будет принадлежать деп (можно null)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parent_department_id")
    private Department parentDepartment;

    //депы в подчинение
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentDepartment",
            fetch = FetchType.LAZY)
    private List<Department> subDepartments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="organization_id")
    private Organization organization;


    //к какому филлиалу относится деп (можно null)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="branch_id")
    private Branch branch;

}
