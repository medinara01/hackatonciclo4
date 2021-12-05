/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.repository;

import Hackaton.Problema8.models.Comments;
import Hackaton.Problema8.models.Users;
import Hackaton.Problema8.mongoRepositories.MRepositoryComments;
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
public class CommentsRepository {
    @Autowired
    private MRepositoryComments repository;
    
    public List<Comments> getAll(){
        return repository.findAll();
    }
    
    public Optional<Comments> getComments(String idComment){
        return repository.findById(idComment);
    }
    
    public Comments create(Comments comments){
        return repository.save(comments);
    }
    
    public void update(Comments comments){
        repository.save(comments);
    }
    
    public void delete(Comments comments){
        repository.delete(comments);
    }
    
}
