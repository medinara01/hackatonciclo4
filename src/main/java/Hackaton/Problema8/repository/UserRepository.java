/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.repository;

import Hackaton.Problema8.models.Users;
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
public class UserRepository {
    @Autowired
    private MRepositoryUser repository;
    
    public List<Users> getAll(){
        return repository.findAll();
    }
    
    public Optional<Users> getUsers(int identification){
        return repository.findById(identification);
    }
    
    public Users create(Users users){
        return repository.save(users);
    }
    
    public void update(Users users){
        repository.save(users);
    }
    
public void delete(Users users){
        repository.delete(users);
    }
    public boolean emailExists(String email) {
        Optional<Users> usuario = repository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<Users> authenticateUser(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
     
    
    
}
