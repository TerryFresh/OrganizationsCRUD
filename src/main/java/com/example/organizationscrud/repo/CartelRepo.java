package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Cartel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartelRepo extends CrudRepository<Cartel, Long> {
}
