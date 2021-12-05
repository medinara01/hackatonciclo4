/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.repository;

import Hackaton.Problema8.models.Bike;
import Hackaton.Problema8.models.Users;
import Hackaton.Problema8.mongoRepositories.MRepositoryBike;
import Hackaton.Problema8.mongoRepositories.MRepositoryUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class BikeRepository {
    @Autowired
    private MRepositoryBike repository;
    
    public List<Bike> getAll(){
        return repository.findAll();
    }
    
    public Optional<Bike> getBike(String name){
        return repository.findById(name);
    }
    
    public Bike create(Bike bike){
        return repository.save(bike);
    }
    
    public void update(Bike bike){
        repository.save(bike);
    }
    
    public void delete(Bike bike){
        repository.delete(bike);
    }
    
}
