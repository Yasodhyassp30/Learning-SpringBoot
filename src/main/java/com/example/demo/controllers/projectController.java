package com.example.demo.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.projectModel;
import com.example.demo.services.projectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/projects")
public class projectController {

    @Autowired
    private projectService projectServiceInstance;

    @PostMapping("/create")
    public ResponseEntity<Object> createProject(@RequestBody projectModel project) {
        try{
            projectServiceInstance.createProject(project);
            return ResponseEntity.status(201).body(project);
        }catch(Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
       
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> editProjectDetails(@PathVariable UUID id, @RequestBody projectModel project) {
        try{
            projectServiceInstance.editProjectDetails(id,project);
            return ResponseEntity.status(200).body(project);
        }catch(Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object>  deleteProject(@PathVariable UUID id) {
       try{
        projectServiceInstance.deleteProject(id);
        return ResponseEntity.status(200).body("Project deleted successfully");

       }catch(Exception e){
           return ResponseEntity.status(400).body(e.getMessage());
       }
    }

    @GetMapping("/getByCreator")
    public ResponseEntity<Object> getProjectBycreator(@RequestParam UUID id) {
        try{
            return ResponseEntity.status(200).body(projectServiceInstance.getProjectBycreator(id));
        }catch(Exception e){
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    
}
