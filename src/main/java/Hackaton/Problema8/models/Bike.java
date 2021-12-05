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

@Document(collection = "bikes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {
    @Id
    private String serialNumber;
    private Integer OwnerId;
    private String brand;
    private String description;
    private String type;
    private String rin;
    private String availability;
    private String photography1;
    private String photography2;
    private String lastMechanic;
    private Integer calificationBike;
   
    
}
