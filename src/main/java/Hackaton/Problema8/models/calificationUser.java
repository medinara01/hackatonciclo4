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

@Document(collection = "calificationuser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class calificationUser {
    @Id
    private String idCali;
    private Integer identificationOwner;
    private String nameUser;
    private String nameBike;
    private String comment;
    private Integer calificationUser;
}
