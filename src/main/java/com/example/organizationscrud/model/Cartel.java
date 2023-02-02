package com.example.organizationscrud.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@EqualsAndHashCode
public class Cartel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonManagedReference(value = "organization-cartel")
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = "cartel",
            fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Organization> organization;
}
