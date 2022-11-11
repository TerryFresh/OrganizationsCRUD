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
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //название филиала
    private String name;

    //какой орги филлиал
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="organization_id")
    private Organization organization;

    //Какие депы в филлиале
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "branch",
            fetch = FetchType.LAZY)
    private List<Department> department;
}
