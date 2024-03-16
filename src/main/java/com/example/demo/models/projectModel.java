package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;

import java.util.List;
import java.util.UUID;

import com.example.demo.helpers.StringListConverter;
import com.google.gson.Gson;




@Entity
@Table(name = "projects")

public class projectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "uid")
    private UUID creatorUuid;
    
    private String name;
    private String description;
    private String status;


    private String importance;
    private String deadline;


    public projectModel(String name, String description, String status, String importance, String deadline, UUID creator) {
    
        this.name = name;
        this.description = description;
        this.status = status;
        this.importance = importance;
        this.deadline = deadline;
        this.creatorUuid = creator;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }


    
}
