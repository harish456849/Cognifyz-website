package com.cognifyz.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognifyz.backend.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(String email);
}
