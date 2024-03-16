
package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.projectModel;
import com.example.demo.models.taskModel;

import java.util.List;
import java.util.UUID;



public interface projectRepository extends JpaRepository<projectModel, UUID> {
     List<projectModel> findByid(UUID projectId);
     List<projectModel> findByCreator_Id(UUID creatorId);
     

}
