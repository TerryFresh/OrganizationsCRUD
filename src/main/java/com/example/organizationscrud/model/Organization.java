package com.example.organizationscrud.model;

import com.fasterxml.jackson.annotation.*;
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

    @JsonBackReference(value = "organization-cartel")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cartel_id")
    private Cartel cartel;

    @JsonManagedReference(value = "organization-branch")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "organization",
            fetch = FetchType.LAZY)
    private List<Branch> branch;

    @JsonManagedReference(value = "organization-department")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "organization",
            fetch = FetchType.LAZY)
    private List<Department> department;

}












