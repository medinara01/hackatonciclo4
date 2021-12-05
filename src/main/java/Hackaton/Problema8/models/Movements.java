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
@Document(collection = "movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movements {
    @Id
    private Integer id;
    private String user;
    private String date;
    private Integer time;
    private String devolutionTime;
    private String serialNumber;
    private Boolean request;
    
}


