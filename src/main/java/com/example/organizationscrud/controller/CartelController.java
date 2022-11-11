package com.example.organizationscrud.controller;

import com.example.organizationscrud.model.Cartel;
import com.example.organizationscrud.service.CartelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartel")
public class CartelController {

    @Autowired
    CartelService cartelService;

    @GetMapping("/getCartel/{id}")
    public Cartel showEmployee(@PathVariable(value = "id") Long id){
        return cartelService.getCartel(id);
    }

    @GetMapping("/showAllCartel")
    public List<Cartel> showAllCartel(){
        return cartelService.getAllCartel();
    }

    @PostMapping("/saveCartel")
    public void saveCartel(@RequestBody Cartel cartel){
        cartelService.saveCartel(cartel);
    }

    @PutMapping("/updateCartel/{id}")
    public Cartel updateCartel(@RequestBody Cartel cartel, @PathVariable Long id){
        cartelService.saveCartel(cartel);
        return cartelService.getCartel(cartel.getId());
    }

    @DeleteMapping("/deleteCartel/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCartel(@PathVariable(value = "id") Long id){
        cartelService.deleteCartel(id);
    }
}
