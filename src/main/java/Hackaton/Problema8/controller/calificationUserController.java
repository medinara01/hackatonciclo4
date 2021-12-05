/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.controller;

import Hackaton.Problema8.models.calificationUser;
import Hackaton.Problema8.service.calificationUserService;
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
@RequestMapping("/api/califuser")
@CrossOrigin("*")
public class calificationUserController {
    @Autowired
    private calificationUserService califService;
       
     @GetMapping("/all")
    public List<calificationUser> getAll() {
        return califService.getAll();
    }
    
    @GetMapping("/{idCali}")
    public Optional<calificationUser> getCalificationU(@PathVariable("idCali") String idCali) {
        return califService.getCalificationU(idCali);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public calificationUser create(@RequestBody calificationUser califu) {
        return califService.create(califu);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public calificationUser update(@RequestBody calificationUser califu) {
        return califService.update(califu);
    }

    @DeleteMapping("/{serialNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idCali") String idCali) {
        return califService.delete(idCali);
    } 
}
