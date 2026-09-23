package com.cognifyz.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognifyz.backend.entity.Task;
import com.cognifyz.backend.entity.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByUser(User user);
}
