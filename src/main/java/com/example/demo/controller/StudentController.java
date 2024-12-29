package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repo.ModuleRepo;
import com.example.demo.repo.StudentRepo;


@RestController
public class StudentController {

    Logger logger
        = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentRepo studentRepository;
    
    @Autowired
    ModuleRepo moduleRepository;
    
    @PostMapping("/addStudent")
    public Student addStudent(@RequestParam String name, @RequestParam Long majorId) {
        Student student = new Student();
        logger.warn(student.toString());
        student.setName(name);
        student.setMajorId(majorId);
        return studentRepository.save(student);
    }

    @PutMapping("/addModuleToStudent")
    public Student addModuleToStudent(@RequestParam Long studentId, @RequestParam Long moduleId) {
        var foundStudent = studentRepository.findById(studentId);
        if(foundStudent.isEmpty()) {
            return null;
        } else {
            var student = foundStudent.get();
            var foundModule = moduleRepository.findById(moduleId);
            if(foundModule.isEmpty()) {
                return null;
            } else {
                var module = foundModule.get();
                student.getModules().add(module);
                return studentRepository.save(student);
            }
        }
    }
    

    @GetMapping("/getstudentbyid")
    public Student getStudentById(@RequestParam String id) {
        logger.warn(id);
        var foundStudent = studentRepository.findById(Long.valueOf(id));
        if(foundStudent.isEmpty()) {
            return null;
        } else {
            // get populated modules
            var student = foundStudent.get();
            student.getModules().size();
            return student;
        }
    }
}
