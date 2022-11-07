package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;

import java.util.List;

public interface CartelService{

    public Cartel getCartel(Long id);

    public List<Cartel> getAllCartel();

    public void saveCartel(Cartel cartel);

    public void deleteCartel(Long id);
}
