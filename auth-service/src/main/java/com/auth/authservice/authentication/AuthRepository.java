package com.auth.authservice.authentication;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthModel, UUID>{
    Optional<AuthModel> findByEmail(String email);
    
}
