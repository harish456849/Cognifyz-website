package com.cognifyz.backend.controller;

import com.cognifyz.backend.dto.LoginRequest;
import com.cognifyz.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cognifyz.backend.security.JwtService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService,
                          JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest request) {

        boolean authenticated = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        if (authenticated) {
        	String token = jwtService.generateToken(request.getEmail());
        	return ResponseEntity.ok(token);
        }

        return ResponseEntity
                .status(401)
                .body("Invalid email or password");
    }
}