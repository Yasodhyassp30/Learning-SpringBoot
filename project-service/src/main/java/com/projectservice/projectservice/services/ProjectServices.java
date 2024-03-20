package com.projectservice.projectservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectservice.projectservice.models.ProjectModel;
import com.projectservice.projectservice.repos.ProjectRepo;

@Service
public class ProjectServices {
    @Autowired
    private ProjectRepo projectRepo;

    public ProjectModel createProject(ProjectModel project) {
        return projectRepo.save(project);
    }

    public ProjectModel getProjectById(UUID id) {
        return projectRepo.findById(id).orElse(null);
    }

    public List<ProjectModel> getProjectByCreator(UUID creator) {
        return projectRepo.findByCreatorUuid(creator);
    }

    public void updateProject(ProjectModel project) {
         projectRepo.updateProject(project.getId(), project.getName(), project.getDescription(), project.getStatus(), project.getImportance(), project.getDeadline());
    }

    public void deleteProject(UUID id) {
        projectRepo.deleteById(id);
    }


}
