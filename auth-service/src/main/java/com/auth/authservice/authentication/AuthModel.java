package com.auth.authservice.authentication;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class AuthModel {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uid;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    @Size(max=255,message = "Email should be less than 255")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min=8,message = "Password should be greater than 8")
    private String password;

    @NotBlank(message = "Role is mandatory")
    @Pattern(regexp = "^(Student|Teacher)$",message = "Role should be either Student or Teacher")
    private String role;

    @NotBlank(message = "Username is mandatory")
    @Size(max=255,message = "Username should be less than 255")
    private String username;


    public AuthModel() {}
    public AuthModel(UUID uid, String email, String password, String role, String username) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public UUID getUid() {
        return this.uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("uid", this.uid.toString());
        map.put("email", this.email);
        map.put("role", this.role);
        map.put("username", this.username);
        return map;
    }





}
