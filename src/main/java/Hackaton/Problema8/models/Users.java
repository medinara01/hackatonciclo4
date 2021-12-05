/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hackaton.Problema8.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author johan
 */

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private Integer identification;
    private String idtype;
    private String name ;
    private String email;
    private String cellPhone;
    private String country;
    private String city;
    private String location;
    private String neighborhood;
    private String address;
    private String twitter; //optional
    private String facebook; //optional
    private String instagram; //optional
    private String google; //required
    private String password;
    private String calificationOwner;
    private String calificationUser;
    private Integer tokens;
   
}

