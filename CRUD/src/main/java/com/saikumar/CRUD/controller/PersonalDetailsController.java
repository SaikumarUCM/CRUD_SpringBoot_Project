package com.saikumar.CRUD.controller;

import com.saikumar.CRUD.model.PersonalDetails;
import com.saikumar.CRUD.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The @RestController annotation is used in Spring Framework to indicate that a class serves as a RESTful Controller
 *
 * @RestController is a specialized version of the @Controller annotation with the additional feature of automatically
 * including the @ResponseBody annotation on all handler methods.
 *
 * If we use @Controller annotation, then for every method in the class, we need to annotate @ResponseBody.
 *
 * with @RestController automatically includes the @ResponseBody.
 *
 *
 *
 * @RequestMapping("/abcde") allows us to define the URL patterns and HTTP methods that a particular handler method should respond to.
 *
 */

@RestController
@RequestMapping("/details")
public class PersonalDetailsController {


                    // In The controller class, we follow RESTful architecture.
                    /** RESTful Architecture
                     *   REST stands for Representational State Transfer. It is an architecture style that defines a
                     *   set of principles for designing networked applications
                     *
                     *   RESTful architecture emphasizes a stateless client-server communication model,where the server provides
                     *   resources and the client performs actions on those resources using the standard HTTP methods
                     *
                     *   HTTP methods are similar to CRUD operations
                     *
                     *   POST -> Create or Add a new data in database
                     *   PUT  -> modify or Update data in database
                     *   GET  -> Get the data from the  database
                     *   DELETE  -> delete the data from the database
                     *   PATCH  -> It is same as PUT, The only difference is , if you want to modify the fname, then in PUT,
                     *              we need to pass (Id, fname, lname , address) even we are not changing the lname and address.
                     *              But in PATCH we only pass (Id, fname), we only pass the modifying values.
                     */



                     // In order to call the service class for Controller, we need to do Dependency Injection.(i.e inject service
                    //   class in controller class. That can be done using the @AutoWired annotation)

                    /**
                     * The @AutoWired annotation is used in Spring Framework to automatically inject dependencies into a class
                     *  It reduces manual bean wiring and allows  for more flexible and maintainable code
                     */



    @Autowired
    public PersonalDetailsService personalDetailsService;

    /**
     * @PostMapping is used to map HTTP POST requests to a specific handler method in a controller class.
     */
    // when ever a user want to add details, they will send /details/add to send the request.

    /**
     * @RequestBody: It is commonly used when we want to extract and process data sent by the client in the request body.Data type will be model class
     */
    @PostMapping("/add")
    public String addDetails(@RequestBody PersonalDetails personalDetails){

        personalDetailsService.addDetails(personalDetails);
        return "success";

    }

    @GetMapping("/getAll")
    public List<PersonalDetails> getAll(){
        List<PersonalDetails> personalDetails=null;
        personalDetails=personalDetailsService.getAll();
        return personalDetails;
    }


    /**
     * @PathVariable: is an annotation used in Spring Boot to extract variables from the URL path and use them as
     *  method parameters in a controller class.
     *
     */
    @GetMapping("/getById/{id}")
    public Optional<PersonalDetails> getById(@PathVariable Integer id){
        Optional<PersonalDetails> personalDetails =null;
        personalDetails=personalDetailsService.getById(id);
        return personalDetails;
    }

    /**
     * @PutMapping: is an annotation used in Spring boot to handle HTTP PUT requests for a specific endpoint in a controller class.
     */
    @PutMapping("/update/{id}")
    public String updateById(
            @PathVariable Integer id,
            @RequestBody  PersonalDetails personalDetails
    ){
            personalDetailsService.updateById(id,personalDetails);
            return "Success";
    }


    /** @DeleteMapping:
     *  is an annotation used in Spring Boot to handle HTTP DELETE requests for a specific endpoint in a controller class.
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        personalDetailsService.delete(id);
        return "Deleted Successfully";
    }


}
