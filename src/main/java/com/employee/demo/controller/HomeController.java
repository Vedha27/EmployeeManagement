package com.employee.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 @GetMapping({"/", "/index"})
	    public String showIndex() {
	        return "index.html"; // loads templates/index.html
	    }
}
