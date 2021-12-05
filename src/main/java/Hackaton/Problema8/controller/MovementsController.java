/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.controller;

import Hackaton.Problema8.models.Movements;
import Hackaton.Problema8.service.MovementsService;
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
@RequestMapping("/api/movements")
@CrossOrigin("*")
public class MovementsController {
    @Autowired
    private MovementsService moveService;
       
     @GetMapping("/all")
    public List<Movements> getAll() {
        return moveService.getAll();
    }
    
    @GetMapping("/{serialNumber}")
    public Optional<Movements> getClothe(@PathVariable("id") int id) {
        return moveService.getMovements(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Movements create(@RequestBody Movements movements) {
        return moveService.create(movements);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Movements update(@RequestBody Movements movements) {
        return moveService.update(movements);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return moveService.delete(id);
    } 
}
