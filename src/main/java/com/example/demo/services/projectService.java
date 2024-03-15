package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.projectRepository;
import com.example.demo.models.projectModel;

import java.util.UUID;

@Service
public class projectService {

    @Autowired
    private projectRepository projectRepository;

    public void  createProject(projectModel project) {
        projectRepository.save(project);
    }

    public void editProjectDetails(UUID id, projectModel project) {

        projectRepository.save(project);
    }

    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }
}
