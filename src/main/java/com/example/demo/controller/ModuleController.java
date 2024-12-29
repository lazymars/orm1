package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Module;
import com.example.demo.repo.ModuleRepo;


@RestController
public class ModuleController {

    Logger logger
        = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    ModuleRepo moduleRepository;
    
    @PostMapping("/addModule")  
    public String addModule(@RequestParam String name, @RequestParam Long majorId) {
        Module module = new Module();
        logger.warn(module.toString());
        module.setName(name);
        module.setMajorId(majorId);
        moduleRepository.save(module);
        return "item added successfully";
    }

    @GetMapping("/getmodulebyid")
    public String getModuleById(@RequestParam String id) {
        logger.warn(id);
        var foundModule = moduleRepository.findById(Long.valueOf(id));
        if(foundModule.isEmpty()) {
            return "didn't find";
        } else {
            return foundModule.toString(); 
        }
    }
}