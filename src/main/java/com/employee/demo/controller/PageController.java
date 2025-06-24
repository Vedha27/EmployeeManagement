package com.employee.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {	

    // Employees Page
    @GetMapping("/employees")
    public String employeesPage() {
        return "employees.html";
    }

    // Sorted Employees Page
    @GetMapping("/employees/sorted")
    public String sortedEmployeesPage() {
        return "employees-sorted.html";
    }

    // Contact Us Page
    @GetMapping("/contact")
    public String contactPage() {
        return "contact.html";
    }

    // About Us Page
    @GetMapping("/about")
    public String aboutPage() {
        return "about.html";
    }
}
