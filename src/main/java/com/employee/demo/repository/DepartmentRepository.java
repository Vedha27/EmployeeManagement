package com.employee.demo.repository;
import com.employee.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
