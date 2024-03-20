package com.authservice.authservice.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.authservice.models.UserModels;

public interface UserRepository extends JpaRepository<UserModels, UUID>{
    
        UserModels findByEmail(String email);
    
}