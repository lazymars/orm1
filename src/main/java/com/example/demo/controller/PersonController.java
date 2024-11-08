package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;


@RestController
public class PersonController {

    Logger logger
        = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonRepo repo;
    
    @PostMapping("/addPerson")
    public String addPerson(@RequestBody Person person) {
        
        logger.warn("___________________________________person:__________________________________");
        logger.warn(person.toString());
        repo.save(person);
        return "item added successfully";
    }
    @GetMapping("/getpersonbyid")
    public String getPersonById(@RequestParam String id) {
        logger.warn(id);
        var foundPerson = repo.findById(Long.valueOf(id));
        if(foundPerson.isEmpty()) {
            return "didn't find";
        } else {
            return foundPerson.toString(); 
        }
    }
    
}
