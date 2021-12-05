/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.repository;

import Hackaton.Problema8.models.Comments;
import Hackaton.Problema8.models.Movements;
import Hackaton.Problema8.mongoRepositories.MRepositoryComments;
import Hackaton.Problema8.mongoRepositories.MRepositoryMovements;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class MovementsRepository {
    @Autowired
    private MRepositoryMovements repository;
    
    public List<Movements> getAll(){
        return repository.findAll();
    }
    
    public Optional<Movements> getMovements(Integer id){
        return repository.findById(id);
    }
    
    public Movements create(Movements movements){
        return repository.save(movements);
    }
    
    public void update(Movements movements){
        repository.save(movements);
    }
    
    public void delete(Movements movements){
        repository.delete(movements);
    }
}
