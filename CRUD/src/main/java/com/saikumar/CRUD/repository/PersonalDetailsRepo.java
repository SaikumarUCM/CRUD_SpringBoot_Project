package com.saikumar.CRUD.repository;


import com.saikumar.CRUD.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The @Repository annotation is used in Spring Framework to indicate that a class serves as a repository,
 * which is a type of component that interacts with a database or data source
 */

// To perform some default operations on database, we extend interface with another interface (JpaRepository)
//  JpaRepository accepts 2 parameters. They are Entity class and type of Primary key.


/**
 * JpaRepository<Entity Class , Type of PrimaryKey>:
 * The JpaRepository interface provides a basic CRUD operations and additional methods for
 * querying and working with entities.
 * for Example, The JpaRepository interface provides methods like save(),findById(), findAll(),deleteById()
 */

@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails,Integer> {


}
