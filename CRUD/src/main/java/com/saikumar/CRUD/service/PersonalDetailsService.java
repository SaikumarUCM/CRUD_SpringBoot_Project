package com.saikumar.CRUD.service;


import com.saikumar.CRUD.model.PersonalDetails;
import com.saikumar.CRUD.repository.PersonalDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * The @Service annotation is used in Spring Framework to indicate that a class represents a service component.
 * It is typically used to mark a class that performs business logic operations , acts as an intermediary between
 * the controller and the repository.
 *
 * The flow of application
 *
 *   user ->  Controller  -> Service  -> Repository(i.e a component that interacts with Database)
 *
 *   To Create a new data in our database or to delete a existing data in the database, in order to do that
 *   the user sends a request. That request first comes to our controller. so this controller will then send the request
 *   to our service class, there all the business logic is present and service class after executing certain logic interacts
 *   with our repository gets the data or modifies the data or create the data.
 *
 */
@Service
public class PersonalDetailsService {

    @Autowired
    private PersonalDetailsRepo personalDetailsRepo;

    public void addDetails(PersonalDetails personalDetails){
        personalDetailsRepo.save(personalDetails);
    }

    public List<PersonalDetails> getAll(){
         List<PersonalDetails> personalDetails=null;
         personalDetails=personalDetailsRepo.findAll();

         return personalDetails;
    }

    public Optional<PersonalDetails> getById(Integer id){
        Optional<PersonalDetails> personalDetails=null;
        personalDetails=personalDetailsRepo.findById(id);
        return personalDetails;
    }

    public void updateById(Integer id,PersonalDetails personalDetails){
        var personalDetails1=personalDetailsRepo.findById(id).orElse(null);

        if(personalDetails1==null){
            throw new RuntimeException("Personal Details not found for given id");
        }


        personalDetails1.setAddress(personalDetails.getAddress());
        personalDetails1.setFname(personalDetails.getFname());
        personalDetails1.setLname(personalDetails.getLname());
        personalDetails1.setPhone(personalDetails.getPhone());
        personalDetailsRepo.save(personalDetails1);

    }


    public void delete(Integer id){
        personalDetailsRepo.deleteById(id);
    }



}
