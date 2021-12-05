/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.service;

import Hackaton.Problema8.models.Users;
import Hackaton.Problema8.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;
            
    public List<Users> getUsers(){
        return userRepository.getAll();
    }
    
    public Optional<Users> getUsers(int identification){
        return userRepository.getUsers(identification);
    }
    
   public Users create(Users users){
       if (users.getIdentification() == null){
           return users;
       }else {
           Optional<Users> e = userRepository.getUsers(users.getIdentification());
            if (e.isEmpty()) {
                if (emailExists(users.getEmail())==false){
                    return userRepository.create(users);
                }else{
                    return users;
                }
            }else{
                return users;
            }           
       }
   }
   
   public Users update (Users users){
       
       if (users.getIdentification() != null){
           Optional<Users> usersDb = userRepository.getUsers(users.getIdentification());
           if (!usersDb.isEmpty()){
               
               if (users.getIdtype()!=null){
                   usersDb.get().setIdtype(users.getIdtype());
               }
               if (users.getName()!=null){
                   usersDb.get().setName(users.getName());
               }
               if (users.getEmail()!=null){
                   usersDb.get().setEmail(users.getEmail());
               }
               if (users.getCellPhone()!=null){
                   usersDb.get().setCellPhone(users.getCellPhone());
               }
               if (users.getCountry()!=null){
                   usersDb.get().setCountry(users.getCountry());
               }
               if (users.getCity()!=null){
                   usersDb.get().setCity(users.getCity());
               }
               if (users.getLocation()!=null){
                   usersDb.get().setLocation(users.getLocation());
               }
               if (users.getNeighborhood()!=null){
                   usersDb.get().setNeighborhood(users.getNeighborhood());
               }
               if (users.getAddress()!=null){
                   usersDb.get().setAddress(users.getAddress());
               }
               if (users.getTwitter()!=null){
                   usersDb.get().setTwitter(users.getTwitter());
               }
               if (users.getFacebook()!=null){
                   usersDb.get().setFacebook(users.getFacebook());
               }
               if (users.getInstagram()!=null){
                   usersDb.get().setInstagram(users.getInstagram());
               }
               if (users.getGoogle()!=null){
                   usersDb.get().setGoogle(users.getGoogle());
               }
               if(users.getPassword()!=null){
                   usersDb.get().setPassword(users.getPassword());
               }
               if (users.getCalificationOwner()!=null){
                   usersDb.get().setCalificationOwner(users.getCalificationOwner());
               }
               if (users.getCalificationUser()!=null){
                   usersDb.get().setCalificationUser(users.getCalificationUser());
               }
               if(users.getTokens()!=0){
                   usersDb.get().setTokens(users.getTokens());
               }
               userRepository.update(usersDb.get());
               return usersDb.get();
           }else{
               return users;
           }
       }else{
           return users;
       }
       
   }
   
public boolean delete(int identification) {
        Boolean aBoolean = getUsers(identification).map(users -> {
            userRepository.delete(users);
            return true;
        }).orElse(false);
        return aBoolean;
    }
public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public Users authenticateUsers(String email, String password) {
        Optional<Users> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new Users();
        } else {
            return usuario.get();
        }
    }
}