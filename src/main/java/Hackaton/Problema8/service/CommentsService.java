/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.service;

import Hackaton.Problema8.models.Comments;
import Hackaton.Problema8.repository.CommentsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    
     public List<Comments> getAll(){
        return commentsRepository.getAll();
    }
    
    public Optional<Comments> getComments(String idComment){
        return commentsRepository.getComments(idComment);
    }
    
   public Comments create(Comments comments){
       if (comments.getSerialNumber()== null){
           return comments;
       }else {
           return commentsRepository.create(comments);
       }
   }
   
   public Comments update (Comments comments){
       
       if (comments.getIdComment()!= null){
           Optional<Comments> commentsDb = commentsRepository.getComments(comments.getIdComment());
           if (!commentsDb.isEmpty()){
               if (comments.getSerialNumber()!=null){
                   commentsDb.get().setSerialNumber(comments.getSerialNumber());
               }
               
               if (comments.getUserName()!=null){
                   commentsDb.get().setUserName(comments.getUserName());
               }
               if (comments.getComment()!=null){
                   commentsDb.get().setComment(comments.getComment());
               }
               if (comments.getCalificationBike()!=0){
                   commentsDb.get().setCalificationBike(comments.getCalificationBike());
               }
               if (comments.getCalificationOwner()!=null){
                   commentsDb.get().setCalificationOwner(comments.getCalificationOwner());
               }
               
               commentsRepository.update(commentsDb.get());
               return commentsDb.get();
           }else{
               return comments;
           }
       }else{
           return comments;
       }
       
   }
   

   

public boolean delete(String idComment) {
        Boolean aBoolean = getComments(idComment).map(comments -> {
            commentsRepository.delete(comments);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
}
