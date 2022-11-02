package com.example.organizationscrud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String secondName;

    //в какой орге раб
    @ManyToOne
    @JoinColumn(name="organization_id")
    private Organization organization;

    //в каком депе раб
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Department department;

    //является ли главой депа (можно null)
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="head_department_id")
    private Department headOfDepartment;

}
