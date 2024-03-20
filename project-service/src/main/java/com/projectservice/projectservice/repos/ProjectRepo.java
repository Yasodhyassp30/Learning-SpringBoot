package com.projectservice.projectservice.repos;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.projectservice.projectservice.models.ProjectModel;

import jakarta.transaction.Transactional;

public interface ProjectRepo extends JpaRepository<ProjectModel, UUID>{
    Optional<ProjectModel> findById(UUID id);
    List<ProjectModel> findByCreatorUuid(UUID creatorUuid);

    @Transactional
    @Modifying
    @Query("UPDATE ProjectModel p SET " +
           "p.name = :name, " +
           "p.description = :description, " +
           "p.status = :status, " +
           "p.importance = :importance, " +
           "p.deadline = :deadline " +
           "WHERE p.id = :id")
    void updateProject(UUID id, String name, String description, String status, String importance, String deadline);
} 