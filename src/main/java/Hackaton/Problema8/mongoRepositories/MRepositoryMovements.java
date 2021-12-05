/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Hackaton.Problema8.mongoRepositories;

import Hackaton.Problema8.models.Movements;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author johan
 */
public interface MRepositoryMovements extends MongoRepository<Movements, Integer>{
    
}
