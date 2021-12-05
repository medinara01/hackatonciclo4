/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Hackaton.Problema8.mongoRepositories;

import Hackaton.Problema8.models.Users;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author johan
 */

public interface MRepositoryUser extends MongoRepository<Users, Integer> {
    @Autowired

    public Optional<Users> findByEmail(String email);

    public Optional<Users> findByEmailAndPassword(String email, String password);
}
