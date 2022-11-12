package com.example.organizationscrud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    @JsonBackReference(value = "organization-branch")
    private Organization organization;

    @JsonManagedReference(value = "branch-department")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "branch",
            fetch = FetchType.LAZY)
    private List<Department> department;
}
