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
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //кто с кем объединяется
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "organization_cartel",
            joinColumns = @JoinColumn(name="organization_id"),
            inverseJoinColumns = @JoinColumn(name="cartel_id"))
    private List<Cartel> cartel;

    //Какие филлиалы имеются
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "organization",
            fetch = FetchType.LAZY)
    private List<Branch> branch;

    //депы в подчинение
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "organization",
            fetch = FetchType.LAZY)
    private List<Department> subDepartments;


}
