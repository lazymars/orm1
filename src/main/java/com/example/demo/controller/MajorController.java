package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Major;
import com.example.demo.repo.MajorRepo;

@RestController
public class MajorController {

    Logger logger
        = LoggerFactory.getLogger(MajorController.class);

    @Autowired
    MajorRepo majorRepository;
    
    @PostMapping("/addMajor")
    public String addMajor(@RequestParam String name) {
        Major major = new Major();
        logger.warn(major.toString());
        major.setName(name);
        majorRepository.save(major);
        return "item added successfully";
    }

    @GetMapping("/getmajorbyid")
    public String getMajorById(@RequestParam String id) {
        logger.warn(id);
        var foundMajor = majorRepository.findById(Long.valueOf(id));
        if(foundMajor.isEmpty()) {
            return "didn't find";
        } else {
            return foundMajor.toString(); 
        }
    }
    
}