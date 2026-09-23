package com.cognifyz.backend.controller;

import com.cognifyz.backend.entity.Task;
import com.cognifyz.backend.entity.User;
import com.cognifyz.backend.repository.TaskRepository;
import com.cognifyz.backend.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final UserRepo userRepository;
    Logger logger = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskRepository taskRepository, UserRepo userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        logger.info("task and user repos were injected");
    }

    // Helper method to extract current user from JWT context
    private User getAuthenticatedUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info(email+" is fetching...");
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public List<Task> getUserTasks() {
    	logger.info("Taskes are fetching by users");
        return taskRepository.findByUser(getAuthenticatedUser());
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
    	logger.info("request at create task en point");
        task.setUser(getAuthenticatedUser());
        logger.info("task is creating..");
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (task.getUser().getId() != getAuthenticatedUser().getId()) {
            return ResponseEntity.status(403).body("Access denied");
        }
        logger.info("task is deleted");
        taskRepository.delete(task);
        return ResponseEntity.ok("Deleted successfully");
    }
}