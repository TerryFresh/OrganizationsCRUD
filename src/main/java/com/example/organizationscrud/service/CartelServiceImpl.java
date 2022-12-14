package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Branch;
import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.repo.CartelRepo;
import com.example.organizationscrud.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartelServiceImpl implements CartelService {

    @Autowired
    private CartelRepo cartelRepo;

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
    public void saveCartel(Cartel cartel) {
        cartelRepo.save(cartel);
    }

    @Override
    @Transactional
    public void updateCartel(Cartel cartel, Long id) {
        Cartel newCartel = cartelRepo.findById(id).orElseThrow();
        newCartel.setName(cartel.getName());
        cartelRepo.save(newCartel);
    }

    @Override
    @Transactional
    public void deleteCartel(Long id) {
        cartelRepo.deleteById(id);
    }

}
