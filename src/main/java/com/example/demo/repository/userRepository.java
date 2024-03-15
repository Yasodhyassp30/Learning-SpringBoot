package com.example.demo.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.userModel;


public interface userRepository extends JpaRepository<userModel, UUID>{

    userModel findByEmail(String email);
    
} 