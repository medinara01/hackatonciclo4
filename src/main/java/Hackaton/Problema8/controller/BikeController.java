/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.controller;

import Hackaton.Problema8.models.Bike;
import Hackaton.Problema8.service.BikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johan
 */
@RestController
@RequestMapping("/api/bike")
@CrossOrigin("*")
public class BikeController {
    @Autowired
    private BikeService bikeService;
       
     @GetMapping("/all")
    public List<Bike> getAll() {
        return bikeService.getAll();
    }
    
    @GetMapping("/{serialNumber}")
    public Optional<Bike> getClothe(@PathVariable("serialNumber") String serialNumber) {
        return bikeService.getBike(serialNumber);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike create(@RequestBody Bike bike) {
        return bikeService.create(bike);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike) {
        return bikeService.update(bike);
    }

    @DeleteMapping("/{serialNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("serialNumber") String serialNumber) {
        return bikeService.delete(serialNumber);
    } 
}
