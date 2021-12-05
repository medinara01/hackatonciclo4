/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.controller;

import Hackaton.Problema8.models.Comments;
import Hackaton.Problema8.service.CommentsService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/comments")
@CrossOrigin("*")
public class CommentsController {
   @Autowired
    private CommentsService commentsService;
       
     @GetMapping("/all")
    public List<Comments> getAll() {
        return commentsService.getAll();
    }
    
    @GetMapping("/{idComment}")
    public Optional<Comments> getClothe(@PathVariable("idComment") String idComment) {
        return commentsService.getComments(idComment);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Comments create(@RequestBody Comments bike) {
        return commentsService.create(bike);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Comments update(@RequestBody Comments bike) {
        return commentsService.update(bike);
    }

    @DeleteMapping("/{idComment}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("idComment") String idComment) {
        return commentsService.delete(idComment);
    }  
}
