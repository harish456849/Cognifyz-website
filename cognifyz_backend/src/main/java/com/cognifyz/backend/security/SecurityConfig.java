package com.cognifyz.backend.security;

import org.springframework.security.config.Customizer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cognifyz.backend.controller.TaskController;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableWebSecurity
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
	    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}
	@Bean
	public PasswordEncoder PasswordEncoder() {
		logger.info("PasswordEncoder is called");
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		logger.info("request is at security config");
	    return http
	        .csrf(csrf -> csrf.disable())
	        .cors(Customizer.withDefaults()) // Enabled CORS support in Spring Security
	        .authorizeHttpRequests(auth -> auth
	        	    .requestMatchers(
	        	        org.springframework.http.HttpMethod.OPTIONS,
	        	        "/**"
	        	    ).permitAll()
	        	    .requestMatchers("/test").authenticated()
	        	    .requestMatchers("/api/create").permitAll()
	        	    .requestMatchers("/api/auth/**").permitAll()
	        	    .requestMatchers("/api/tasks/**").authenticated()
	        	    .requestMatchers("/api/tasks").authenticated()// Explicitly permit authenticated JWT access
	        	    .anyRequest().authenticated()
	        	)
	        .addFilterBefore(
	        	    jwtAuthenticationFilter,
	        	    UsernamePasswordAuthenticationFilter.class
	        	)
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Your React URL
	    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	    configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
	    configuration.setAllowCredentials(true);

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	 
}
