package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.userModel;
import com.example.demo.services.userService;

@RestController
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody userModel user) {
        try{
            userService.registeruser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody String email, @RequestBody String password) {
        String message = userService.loginuser(email, password);
        if (message != null) {
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
