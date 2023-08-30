package com.sreenu.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sreenu.ems.entity.Employee;
import com.sreenu.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to EMS ! your officials credentials shared over email. please check once";
	}

	@PostMapping("/create")
	@PreAuthorize("hasAuthority('ROLE_HR') or hasAuthority('ROLE_MANAGER')")
	public Employee onboardNewEmployee(@RequestBody Employee emp) {

		return employeeService.createEmployee(emp);

	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {

		return employeeService.getEmployee(id);

	}

	@GetMapping("/all")
	public List<Employee> getEmployees() {

		return employeeService.getEmployees();
	}

}