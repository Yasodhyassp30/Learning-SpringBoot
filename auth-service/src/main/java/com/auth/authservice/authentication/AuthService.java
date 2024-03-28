package com.auth.authservice.authentication;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.authservice.errorHandler.EntitiyExistsException;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private JwtGenerator jwtGenerator;
    @Autowired
    PasswordEncoder passwordEncoder;



    public Map<String,String> registerUser(AuthModel authModel) {
        if (authRepository.findByEmail(authModel.getEmail()).isPresent()) {
            throw new EntitiyExistsException("Email already exists");
        }else{
            authModel.setPassword(passwordEncoder.encode(authModel.getPassword()));
            Map<String,String> User = authRepository.save(authModel).toMap();
            User.put("token", jwtGenerator.generate(User));
            return User;
        }
        
    }

    public Map<String,String> loginUser(String email,String password) {
       if(authRepository.findByEmail(email).isPresent()){
           AuthModel user = authRepository.findByEmail(email).get();
           if(passwordEncoder.matches(password, user.getPassword())){
            Map<String,String> User = user.toMap();
            User.put("token", jwtGenerator.generate(User));
            return User;
           }else{
               throw new EntitiyExistsException("Invalid credentials");
           }
        }else{
            throw new EntitiyExistsException("User not found");
        }
    }


}
