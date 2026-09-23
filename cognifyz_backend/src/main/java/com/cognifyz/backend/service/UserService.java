package com.cognifyz.backend.service;


import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cognifyz.backend.entity.User;
import com.cognifyz.backend.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class UserService {
    private final UserRepo userrepo;
    private final PasswordEncoder passwordEncoder;
    Logger logger = LoggerFactory.getLogger(UserService.class);
    UserService(UserRepo userrepo, PasswordEncoder passwordEncoder) {
    	logger.info("repo is Injected");
        this.userrepo = userrepo;
        this.passwordEncoder = passwordEncoder;
    }
    
    //User CRUD Operations
    public User Create(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	
    	logger.info("User is Created--from service");
    	return userrepo.save(user);
    	
    }
    public java.util.List<User> getAll() {
    	java.util.List<User> users = new ArrayList<>(userrepo.findAll());
    	logger.info("findAllUsers is Called--from service");
    	return users;
    }
    public User update(User user) {
        User existingUser = userrepo.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + user.getId()));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        logger.info("User is Updated -- from service");
        return userrepo.save(existingUser);
    }

    public void delete(long id) {
    	userrepo.deleteById(id);
    	logger.info("User is Deleted--from service");
    }
    public Optional<User> getById(long id) {
    	logger.info("User is Searched for id--from service");
    	return userrepo.findById(id);
    	
    }
    public boolean login(String email, String password) {

        User user = userrepo.findByEmail(email)
                .orElse(null);

        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(
                password,
                user.getPassword()
        );
    }
	
}
