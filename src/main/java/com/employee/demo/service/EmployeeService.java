package com.employee.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.model.Employee;
import com.employee.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // ✅ Custom Sorting Method
    public List<Employee> getSortedEmployees() {
        return employeeRepository.findAll().stream()
            .sorted(Comparator
                .comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER) // name A-Z
                .thenComparing(emp -> emp.getEmail().length())              // email length asc
                .thenComparing(Comparator.comparing(Employee::getRole, String.CASE_INSENSITIVE_ORDER).reversed()) // role Z-A
            )
            .collect(Collectors.toList());
    }
}
