package com.employee.demo.dto;

import com.employee.demo.model.Employee;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String role;

    // ✅ REQUIRED: Default constructor (for Jackson)
    public EmployeeDTO() {}

    // ✅ Optional: Constructor from entity
    public EmployeeDTO(Employee emp) {
        this.id = emp.getId();
        this.name = emp.getName();
        this.email = emp.getEmail();
        this.role = emp.getRole();
    }

    // ✅ All getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
