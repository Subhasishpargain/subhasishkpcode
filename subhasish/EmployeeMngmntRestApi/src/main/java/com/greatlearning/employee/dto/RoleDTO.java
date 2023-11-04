package com.greatlearning.employee.dto;

public class RoleDTO {
	private Long id;
	private String name;

	public RoleDTO() {
		// Default constructor
	}

	public RoleDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters and setters for all fields

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
