package com.greatlearning.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// You can define custom query methods here if needed
}
