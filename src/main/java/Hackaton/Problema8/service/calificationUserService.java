/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.service;

import Hackaton.Problema8.models.calificationUser;
import Hackaton.Problema8.repository.calificationUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class calificationUserService {
    @Autowired
    private calificationUserRepository califRepository;
            
    public List<calificationUser> getAll(){
        return califRepository.getAll();
    }
    
    public Optional<calificationUser> getCalificationU(String idCali){
        return califRepository.getCalificationU(idCali);
    }
    
   public calificationUser create(calificationUser calificationU){
       if (calificationU.getIdCali() == null){
           return calificationU;
       }else {
           return califRepository.create(calificationU);
       }
   }
   
   public calificationUser update (calificationUser calificationU){
       
       if (calificationU.getIdCali() != null){
           Optional<calificationUser> calificationuserDb = califRepository.getCalificationU(calificationU.getIdCali());
           if (!calificationuserDb.isEmpty()){
              
               
                if (calificationU.getIdentificationOwner()!=null){
                   calificationuserDb.get().setIdentificationOwner(calificationU.getIdentificationOwner());
               }
               if (calificationU.getNameUser()!=null){
                   calificationuserDb.get().setNameUser(calificationU.getNameUser());
               }
               if (calificationU.getNameBike()!=null){
                   calificationuserDb.get().setNameBike(calificationU.getNameBike());
               }
               if (calificationU.getComment()!=null){
                   calificationuserDb.get().setComment(calificationU.getComment());
               }
               if(calificationU.getCalificationUser()!=null){
                   calificationuserDb.get().setCalificationUser(calificationU.getCalificationUser());
               }
               califRepository.update(calificationuserDb.get());
               return calificationuserDb.get();
           }else{
               return calificationU;
           }
       }else{
           return calificationU;
       }
       
   }
   

   

public boolean delete(String idCali) {
        Boolean aBoolean = getCalificationU(idCali).map(calificationU -> {
            califRepository.delete(calificationU);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
