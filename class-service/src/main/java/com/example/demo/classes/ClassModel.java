package com.example.demo.classes;

import java.util.List;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "classes")
public class ClassModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID cid;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Creator id is mandatory")
    @Size(min = 36,max=36, message = "Creator id must be 36 characters")
    @Pattern(regexp = "^[a-f0-9]{8}-[a-f0-9]{4}-[1-5][a-f0-9]{3}-[89ab][a-f0-9]{3}-[a-f0-9]{12}$", message = "Creator id must be a valid UUID")
    private String teacher;
    private String joinCode;
    

    public ClassModel() {
    }

    public ClassModel(UUID cid, String name, String teacher, String joinCode) {
        this.cid = cid;
        this.name = name;
        this.teacher = teacher;
        this.joinCode = joinCode;
    }

    public UUID getCid() {
        return cid;
    }

    public void setCid(UUID cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    public String getJoinCode() {
        return joinCode;
    }

    public void setJoinCode(String joinCode) {
        this.joinCode = joinCode;
    }

    public Map<String,String> ClassModelToMap(ClassModel classModel){
        Map<String,String> classMap = new HashMap<>();
        classMap.put("cid", classModel.getCid().toString());
        classMap.put("name", classModel.getName());
        classMap.put("teacher", classModel.getTeacher().toString());
        classMap.put("joinCode", classModel.getJoinCode());
        return classMap;

    }

}
