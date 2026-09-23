package com.cognifyz.backend.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognifyz.backend.entity.User;
import com.cognifyz.backend.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/api")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
       final UserService userservice;
       Logger logger = LoggerFactory.getLogger(UserController.class);
       //private final List<User> users1 = new ArrayList<>();

	UserController(UserService userservice) {
		logger.info("Service is Injected");
		this.userservice = userservice;
	}
	   @PostMapping(value="/create")
	    public User create(@Valid @RequestBody User user) { 
		   logger.info("User is Created--from Controller");
		   return userservice.Create(user);
	   }

	    @GetMapping(value="/getAll")
	    public List<User> getAll() {
	    	logger.info("Users are searched--from Controller");
	    	return  userservice.getAll(); //userservice.getAll();
	    }

	    @GetMapping("/getById/{id}")
	    public Optional<User> getById(@PathVariable long id) {
	    	logger.info("User is Searched with id--from Controller");
	    	return userservice.getById(id);
	    }

	    @PutMapping("/update")
	    public User update(@RequestBody User user) { 
	    	
	    	logger.info("User is updated--from Controller");
	    	return userservice.update(user);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable long id) {
	    	userservice.delete(id);
	    	logger.info("User is Deleted--from Controller");
	    }
}
