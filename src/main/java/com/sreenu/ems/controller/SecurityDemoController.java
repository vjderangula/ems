package com.sreenu.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to Spring Security Demo";
	}
	
	
	@GetMapping("/text")
	public String greeting() {
		
		return "greeting From Spring Security Demo";
	}
	
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome to Employee Management System Home";
	}

}
