package com.authservice.authservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.authservice.models.UserModels;
import com.authservice.authservice.services.UserServices;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserModels user) {
        try{
            userServices.registerUser(user);
            return ResponseEntity.status(201).body(user);
        }catch(Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody UserModels user) {
        try{
            UserModels user1 = userServices.loginUser(user.getEmail(), user.getPassword());
            return ResponseEntity.status(200).body(user1);
        }catch(Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
