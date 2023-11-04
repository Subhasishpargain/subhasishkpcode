package com.greatlearning.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employee.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
