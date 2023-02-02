package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;

import java.util.List;

public interface CartelService{

    Cartel getCartel(Long id);

    List<Cartel> getAllCartel();

    Cartel saveCartel(Cartel cartel);

    Cartel updateCartel(Cartel cartel, Long id);

    void deleteCartel(Long id);
}
