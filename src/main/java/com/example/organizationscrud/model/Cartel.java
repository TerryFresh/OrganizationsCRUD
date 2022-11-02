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
public class Cartel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //название картеля
    private String name;

    //кто с кем объединяется
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "organization_cartel",
            joinColumns = @JoinColumn(name="cartel_id"),
            inverseJoinColumns = @JoinColumn(name="organization_id"))
    private List<Organization> organization;
}
