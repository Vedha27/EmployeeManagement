package com.employee.demo.service;
import com.employee.demo.model.Department;
import com.employee.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

	  @Autowired
	    private DepartmentRepository departmentRepository;

	    public List<Department> getAllDepartments() {
	        return departmentRepository.findAll();
	    }

	    public Department saveDepartment(Department department) {
	        return departmentRepository.save(department);
	    }
}
