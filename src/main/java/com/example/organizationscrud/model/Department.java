package com.example.organizationscrud.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties()
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "headOfDepartment")
    private Employee employeeHead;

    @JsonManagedReference(value = "department-employeeOfDepartment")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "department",
            fetch = FetchType.LAZY)
    private List<Employee> employeeOfDepartment;

    @JsonManagedReference(value = "subDepartments-parentDepartment")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "parentDepartment",
            fetch = FetchType.LAZY)
    private List<Department> subDepartments;

    @JsonBackReference(value = "subDepartments-parentDepartment")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_department_id")        //не факт что нужна эта строчка
    private Department parentDepartment;

    @JsonBackReference(value = "organization-department")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "branch_id")
    @JsonBackReference(value = "branch-department")
    private Branch branch;

}
