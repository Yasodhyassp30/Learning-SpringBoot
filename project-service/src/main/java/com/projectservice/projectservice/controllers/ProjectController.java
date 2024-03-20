package com.projectservice.projectservice.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectservice.projectservice.models.ProjectModel;
import com.projectservice.projectservice.services.ProjectServices;

@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private  ProjectServices projectServices;

    @PostMapping("/createProject")
    public ResponseEntity<ProjectModel> createProject(@RequestBody ProjectModel project) {
        return ResponseEntity.ok(projectServices.createProject(project));
    }
    @GetMapping("/getPorjectsById")
    public ResponseEntity<List<ProjectModel>> getProjectById(@RequestParam UUID id) {
       List <ProjectModel> projects = projectServices.getProjectByCreator(id);
       return ResponseEntity.ok().body(projects);
    }
    @GetMapping("/UpdateProject")
    public ResponseEntity<String> updateProject(@RequestBody ProjectModel project) {
        try{
           projectServices.updateProject(project);
            return ResponseEntity.ok().body("Project updated successfully");

        }catch (Exception e){
            return ResponseEntity.status(500).body("Error updating project");
        }
    }
    @GetMapping("/deleteProject")
    public ResponseEntity<String> deleteProject(@RequestParam UUID id) {
        try{
            projectServices.deleteProject(id);
            return ResponseEntity.ok().body("Project deleted successfully");

        }catch (Exception e){
            return ResponseEntity.status(500).body("Error deleting project");
        }
    }
    
}
