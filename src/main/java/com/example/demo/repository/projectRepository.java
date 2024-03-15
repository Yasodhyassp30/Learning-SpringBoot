
package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.projectModel;

import java.util.UUID;

public interface projectRepository extends JpaRepository<projectModel, UUID> {
    
}
