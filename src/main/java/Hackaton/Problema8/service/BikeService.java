/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.service;

import Hackaton.Problema8.models.Bike;
import Hackaton.Problema8.repository.BikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;
    
    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }   
    
    public Optional<Bike> getBike(String serialNumber){
        return bikeRepository.getBike(serialNumber);
    }
    
    public Bike create(Bike bike){
        if (bike.getSerialNumber()== null){
            return bike; 
        }else {
            return bikeRepository.create(bike);
        }
    }
    
    public Bike update (Bike bike){
        
        if (bike.getSerialNumber()!= null){
            Optional<Bike> bikesDb = bikeRepository.getBike(bike.getSerialNumber());
            if (!bikesDb.isEmpty()){
                 if (bike.getOwnerId()!=null){
                   bikesDb.get().setOwnerId(bike.getOwnerId());
               }
                if (bike.getBrand()!=null){
                   bikesDb.get().setBrand(bike.getBrand());
               }
               if (bike.getDescription()!=null){
                   bikesDb.get().setDescription(bike.getDescription());
               }
               if (bike.getType()!=null){
                   bikesDb.get().setType(bike.getType());
               }
               if (bike.getRin()!=null){
                   bikesDb.get().setRin(bike.getRin());
               }
                if (bike.getAvailability()!=null){
                  bikesDb.get().setAvailability(bike.getAvailability());
               }
               if (bike.getPhotography1()!=null){
                   bikesDb.get().setPhotography1(bike.getPhotography1());
               }  
                if (bike.getPhotography2()!=null){
                   bikesDb.get().setPhotography2(bike.getPhotography2());
               } 
                if (bike.getLastMechanic()!=null){
                   bikesDb.get().setLastMechanic(bike.getLastMechanic());
               }
                if (bike.getCalificationBike()!=null){
                   bikesDb.get().setCalificationBike(bike.getCalificationBike());
               }
               return bikesDb.get();                
            }else{
                return bike;
            }
        }else{ 
            return bike;
    }
    }
    
    public boolean delete(String name) {
        Boolean aBoolean = getBike(name).map(bike -> {
            bikeRepository.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
