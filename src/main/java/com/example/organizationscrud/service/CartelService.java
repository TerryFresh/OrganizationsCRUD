package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;

import java.util.List;

public interface CartelService{

    Cartel getCartel(Long id);

    List<Cartel> getAllCartel();

    void saveCartel(Cartel cartel);

    void updateCartel(Cartel cartel, Long id);

    void deleteCartel(Long id);
}
