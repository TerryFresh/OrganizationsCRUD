package com.example.organizationscrud.repo;

import com.example.organizationscrud.model.Cartel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartelRepo extends JpaRepository<Cartel, Long> {
}
