package com.example.demo.members;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.classes.ClassModel;
import java.util.Optional;
import java.util.List;

@Repository
public interface MemberRepo extends JpaRepository<MemberModel, Long>{

    com.google.common.base.Optional<MemberModel> findBySid(String sid);
    List<MemberModel> findAllByCourse(ClassModel course);
  
    
} 
