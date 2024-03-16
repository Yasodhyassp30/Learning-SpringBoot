package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.attachementModel;

public interface attachmentRepository extends JpaRepository<attachementModel, Long> {
}