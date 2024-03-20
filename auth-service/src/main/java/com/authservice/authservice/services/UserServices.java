package com.authservice.authservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authservice.authservice.models.UserModels;
import com.authservice.authservice.repos.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public void registerUser(UserModels user) {
        if(userRepository.findByEmail(user.getEmail()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }else{
            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
        }
    }

    public UserModels loginUser(String email, String password) {
        UserModels user = userRepository.findByEmail(email);
        if(user != null) {
            if(user.getPassword().equals(passwordEncoder.encode(password))) {
                return user;
            }else{
                throw new RuntimeException("Invalid password");
            }
        }else{
            throw new RuntimeException("User with email " + email + " does not exist");
        }
    }
}
