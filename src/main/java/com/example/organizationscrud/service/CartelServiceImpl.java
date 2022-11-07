package com.example.organizationscrud.service;

import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.repo.CartelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CartelServiceImpl implements CartelService {

    @Autowired
    EntityManager entityManager;

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
        Cartel newCartel = entityManager.merge(cartel);
        cartel.setId(newCartel.getId());
    }

    @Override
    @Transactional
    public void deleteCartel(Long id) {
        Query query = entityManager.createQuery("delete from Cartel " + "where id =:cartelId");
        query.setParameter("cartelId", id);
        query.executeUpdate();
    }
}
