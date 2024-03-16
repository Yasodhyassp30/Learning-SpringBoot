package com.example.demo.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.taskModel;

public interface taskRepository extends JpaRepository<taskModel, UUID>{
    List<taskModel> findByProject(UUID project);
    List<taskModel> findByAssigned(UUID assigned);
    List<taskModel> findByStatus(String status);
    List<taskModel> findByImportanceAndProject(UUID project, String importance);
}
