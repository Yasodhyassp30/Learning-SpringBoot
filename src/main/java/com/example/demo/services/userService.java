package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.models.userModel;
import com.example.demo.repository.userRepository;


@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registeruser(userModel user) {
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Email already exists");
        }else{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        }
    }

    public String loginuser(String username, String password) {
        userModel user = userRepository.findByEmail(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful";
        }
        return null;
    }

}
