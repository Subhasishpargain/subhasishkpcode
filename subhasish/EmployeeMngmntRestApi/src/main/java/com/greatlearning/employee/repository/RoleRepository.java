package com.greatlearning.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employee.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	// You can define custom query methods here if needed
}
