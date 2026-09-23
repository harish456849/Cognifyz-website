package com.cognifyz.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotBlank(message = "name is required")
	private String name;

	@Email(message = "Enter a valid email")
	@NotBlank(message = "Email is required")
	private String email;
	@NotBlank(message = "pasword is required")
	@Size(min = 6, message = "Password must contain at least 6 characters")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	public User(@NotBlank String name, @Email @NotBlank String email, @NotBlank String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		
	}
	

}
