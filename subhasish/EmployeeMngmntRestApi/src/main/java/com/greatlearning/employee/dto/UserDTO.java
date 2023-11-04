package com.greatlearning.employee.dto;

import java.util.List;

public class UserDTO {
	private Long id;
	private String username;
	private String password;
	private List<RoleDTO> roles;

	public UserDTO() {
		// Default constructor
	}

	public UserDTO(Long id, String username, String password, List<RoleDTO> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	// Getters and setters for all fields

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
}
