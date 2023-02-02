package com.example.organizationscrud.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties()
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@EqualsAndHashCode
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_head_id")
    @ToString.Exclude
    private Employee employeeHead;

    @JsonManagedReference(value = "department-employeeOfDepartment")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "department",
            fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Employee> employeeOfDepartment;

    @JsonManagedReference(value = "subDepartments-parentDepartment")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "parentDepartment",
            fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Department> subDepartments;

    @JsonBackReference(value = "subDepartments-parentDepartment")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_department_id")        //не факт что нужна эта строчка
    @ToString.Exclude
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
