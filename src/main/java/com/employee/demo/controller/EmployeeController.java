package com.employee.demo.controller;

import com.employee.demo.dto.EmployeeDTO;
import com.employee.demo.model.Employee;
import com.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees()
                .stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setRole(dto.getRole());

        Employee saved = employeeService.saveEmployee(emp);
        return new EmployeeDTO(saved);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        Optional<Employee> optional = employeeService.getEmployeeById(id);
        if (optional.isPresent()) {
            Employee emp = optional.get();
            emp.setName(dto.getName());
            emp.setEmail(dto.getEmail());
            emp.setRole(dto.getRole());

            Employee updated = employeeService.saveEmployee(emp);
            return new EmployeeDTO(updated);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    // ✅ GET employee by ID
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        Optional<Employee> optional = employeeService.getEmployeeById(id);
        if (optional.isPresent()) {
            return new EmployeeDTO(optional.get());
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }

    // ✅ GET employees in custom sorted order
    @GetMapping("/sorted")
    public List<EmployeeDTO> getSortedEmployees() {
        return employeeService.getSortedEmployees()
                .stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
