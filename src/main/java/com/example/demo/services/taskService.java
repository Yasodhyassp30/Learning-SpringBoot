package com.example.demo.services;
import com.example.demo.models.taskModel;
import com.example.demo.repository.taskRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class taskService {
    @Autowired
    private taskRepository taskRepository;

    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }

    public void editTaskDetails(UUID id, taskModel task) {
        taskRepository.save(task);
    }

    public void createTask(taskModel task) {
        taskRepository.save(task);
    }

    public void changeTaskStatus(UUID id, String status) {
        taskModel task = taskRepository.findById(id).get();
        task.setStatus(status);
        taskRepository.save(task);
    }

    public void changeTaskImportance(UUID id, String importance) {
        taskModel task = taskRepository.findById(id).get();
        task.setImportance(importance);
        taskRepository.save(task);
    }

    public void changeTaskAssigned(UUID id, UUID assigned) {
        taskModel task = taskRepository.findById(id).get();
        task.setAssigned(assigned);
        taskRepository.save(task);
    }

    public void changeTaskDeadline(UUID id, String deadline) {
        taskModel task = taskRepository.findById(id).get();
        task.setDeadline(deadline);
        taskRepository.save(task);
    }
    
    
}
