package com.example.demo.classes;

import java.util.List;
import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends JpaRepository<ClassModel, UUID>{
    List<ClassModel> findAllByTeacher(String teacher);
    Optional <ClassModel> findById(UUID cid);

    @Query("SELECT c FROM ClassModel c WHERE c.cid = ?1")
    ClassModel findByCid(UUID cid);
    
} 
