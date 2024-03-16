
package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.projectModel;

import java.util.UUID;
import java.util.List;
import java.util.Optional;


public interface projectRepository extends JpaRepository<projectModel, UUID> {


}
