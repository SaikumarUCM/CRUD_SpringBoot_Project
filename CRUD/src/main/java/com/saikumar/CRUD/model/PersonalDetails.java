package com.saikumar.CRUD.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// This annotation makes this class , an entity class.
// The Entity class should be mapped to a database table
@Entity
@Table(name="personaldetails")
@Getter
@Setter
public class PersonalDetails {

    // The ID annotation declares id variable as the primary variable in the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generates the values for id.
    private Integer id;

    private String fname;

    private String lname;
    private Integer phone;
    private String address;

}
