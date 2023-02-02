package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.repo.CartelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartelServiceImpl implements CartelService {

    private final CartelRepo cartelRepo;

    @Autowired
    public CartelServiceImpl(CartelRepo cartelRepo) {
        this.cartelRepo = cartelRepo;
    }

    @Override
    public Cartel getCartel(Long id) {
        return cartelRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Cartel> getAllCartel() {
        return cartelRepo.findAll();
    }

    @Override
    @Transactional
    public Cartel saveCartel(Cartel cartel) {
        return cartelRepo.save(cartel);
    }

    @Override
    @Transactional
    public Cartel updateCartel(Cartel cartel, Long id) {
        Cartel newCartel = cartelRepo.findById(id).orElseThrow();
        newCartel.setName(cartel.getName());
        return cartelRepo.save(newCartel);
    }

    @Override
    public void deleteCartel(Long id) {
        cartelRepo.deleteById(id);
    }

}
