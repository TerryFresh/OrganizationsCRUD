package com.example.organizationscrud.model;

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
public class Cartel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference(value = "organization-cartel")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "cartel",
            fetch = FetchType.LAZY)
    private List<Organization> organization;
}
