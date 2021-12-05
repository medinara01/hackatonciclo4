package Hackaton.Problema8.repository;

import Hackaton.Problema8.models.Movements;
import Hackaton.Problema8.models.calificationUser;
import Hackaton.Problema8.mongoRepositories.MRepositoryMovements;
import Hackaton.Problema8.mongoRepositories.MRepository_calificationUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johan
 */
@Repository
public class calificationUserRepository {
    @Autowired
    private MRepository_calificationUser repository;
    
    public List<calificationUser> getAll(){
        return repository.findAll();
    }
    
    public Optional<calificationUser> getCalificationU(String idCali){
        return repository.findById(idCali);
    }
    
    public calificationUser create(calificationUser calificationU){
        return repository.save(calificationU);
    }
    
    public void update(calificationUser calificationU){
        repository.save(calificationU);
    }
    
    public void delete(calificationUser calificationU){
        repository.delete(calificationU);
    }
}
