package com.example.demo.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table  (name = "attachments")
public class attachementModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "projectid")
    private UUID projectId;


    private String filepath;
    
    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }
    
    public void setFilePath(String filePath) {
        this.filepath = filePath;
    }

    public Long getId() {
        return id;
    }
    public UUID getProjectId() {
        return projectId;
    }
    public String getFilePath() {
        return filepath;
    }
}
