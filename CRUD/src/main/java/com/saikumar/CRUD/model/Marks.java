package com.saikumar.CRUD.model;


import jakarta.persistence.*;


// This annotation makes this class , an entity class.
// The Entity class should be mapped to a database table
@Entity
@Table(name="marks")
public class Marks {

    // The ID annotation declares id variable as the primary variable in the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generates the values for id.
    private Integer id;

    private Integer marks;

}
