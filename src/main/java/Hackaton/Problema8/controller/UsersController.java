/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.controller;

import Hackaton.Problema8.models.Users;
import Hackaton.Problema8.service.UsersService;
import java.util.List;
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
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UsersController {
         @Autowired
    private UsersService usersService;
     
     @GetMapping("/all")
    public List<Users> getAll() {
        return usersService.getUsers();
    }
      @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users users) {
        return usersService.create(users);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Users update(@RequestBody Users users) {
        return usersService.update(users);
    }
    @DeleteMapping("/{identification}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("identification") int identification) {
        return usersService.delete(identification);
    }
    @GetMapping("/{email}/{password}")
    public Users authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return usersService.authenticateUsers(email, password);
    }
      @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return usersService.emailExists(email);
    }
}
