package com.example.demo.controllers;

import com.example.demo.services.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.taskModel;

@RestController
public class taskController {

    @Autowired
    private taskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<Object> createTask(@RequestBody taskModel task) {
        try {
            taskService.createTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating task");
        }
    }

    @PostMapping("/editTaskDetails")
    public ResponseEntity<Object> editTaskDetails(@RequestBody taskModel task) {
        try {
            taskService.editTaskDetails(task.getId(), task);
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error editing task");
        }
    }

    @PostMapping("/deleteTask")
    public ResponseEntity<Object> deleteTask(@RequestBody taskModel task) {
        try {
            taskService.deleteTask(task.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting task");
        }
    }

    @PostMapping("/changeTaskStatus")
    public ResponseEntity<Object> changeTaskStatus(@RequestBody taskModel task) {
        try {
            taskService.changeTaskStatus(task.getId(), task.getStatus());
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error changing task status");
        }
    }

    @PostMapping("/changeTaskImportance")
    public ResponseEntity<Object> changeTaskImportance(@RequestBody taskModel task) {
        try {
            taskService.changeTaskImportance(task.getId(), task.getImportance());
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error changing task importance");
        }
    }

    @PostMapping("/changeTaskAssigned")
    public ResponseEntity<Object> changeTaskAssigned(@RequestBody taskModel task) {
        try {
            taskService.changeTaskAssigned(task.getId(), task.getAssigned());
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error changing task assigned");
        }
    }

    @PostMapping("/changeTaskDeadline")
    public ResponseEntity<Object> changeTaskDeadline(@RequestBody taskModel task) {
        try {
            taskService.changeTaskDeadline(task.getId(), task.getDeadline());
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error changing task deadline");
        }
    }

    

    
    
}
