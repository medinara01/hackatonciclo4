/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.service;

import Hackaton.Problema8.models.Movements;
import Hackaton.Problema8.repository.MovementsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class MovementsService {
   @Autowired
    private MovementsRepository moveRepository;
            
    public List<Movements> getAll(){
        return moveRepository.getAll();
    }
    
    public Optional<Movements> getMovements(int id){
        return moveRepository.getMovements(id);
    }
    
   public Movements create(Movements movements){
       if (movements.getId() == null){
           return movements;
       }else {
           return moveRepository.create(movements);
       }
   }
   
   public Movements update (Movements movements){
       
       if (movements.getId() != null){
           Optional<Movements> movementsDb = moveRepository.getMovements(movements.getId());
           if (!movementsDb.isEmpty()){
               
               if (movements.getUser()!=null){
                   movementsDb.get().setUser(movements.getUser());
               }
               if (movements.getDate()!=null){
                   movementsDb.get().setDate(movements.getDate());
               }
               if (movements.getTime()!=null){
                   movementsDb.get().setTime(movements.getTime());
               }
               if (movements.getDevolutionTime()!=null){
                   movementsDb.get().setDevolutionTime(movements.getDevolutionTime());
               }
               if(movements.getSerialNumber()!=null){
                   movementsDb.get().setSerialNumber(movements.getSerialNumber());
               }
               if(movements.getRequest()!=null){
                   movementsDb.get().setRequest(movements.getRequest());
               }
               moveRepository.update(movementsDb.get());
               return movementsDb.get();
           }else{
               return movements;
           }
       }else{
           return movements;
       }
       
   }
   
public boolean delete(Integer id) {
        Boolean aBoolean = getMovements(id).map(movements -> {
            moveRepository.delete(movements);
            return true;
        }).orElse(false);
        return aBoolean;
    } 
}
