package com.cognifyz.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:3000")
public class TestController {

	Logger logger = LoggerFactory.getLogger(TestController.class);
	@GetMapping
	public String serverCheck() {
		logger.info("Server is Up and Check method is called");
		return "Server is up";
	}
}
