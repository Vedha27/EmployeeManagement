package com.employee.demo.repository;

import com.employee.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
}
