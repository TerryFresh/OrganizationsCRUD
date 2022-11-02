package com.example.organizationscrud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //имя депа
    private String name;

    //кому будет принадлежать деп (можно null)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parent_department_id")
    private Department parentDeparment;

    //работники депа
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "department",
            fetch = FetchType.LAZY)
    private List<Employee> employeeOfDepartment;

    //Глава департамента
    @OneToOne
    @JoinColumn(name="head_employee_id")
    private Employee employeeHead;

    //депы в подчинение
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "parentDeparment",
            fetch = FetchType.LAZY)
    private List<Department> subDepartments;

    //в какой организации деп
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="organization_id")
    private Organization organization;

    //к какому филлиалу относится деп (можно null)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="branch_id")
    private Branch branch;

}
