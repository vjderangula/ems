package com.sreenu.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	private static final String AUTHORITY_ROLE_HR = "hasAuthority('ROLE_HR')";

	private static final String AUTHORITY_ROLE_EMPLOYEE = "hasAuthority('ROLE_EMPLOYEE')";

	private static final String AUTHORITY__ROLE_HR_MANAGER = "hasAuthority('ROLE_HR') or hasAuthority('ROLE_MANAGER')";

	@GetMapping("/welcome")
	public String welcome() {

		return "Welcome to EMS ! your officials credentials shared over email. please check once";
	}

	@PostMapping("/create")
	// @PreAuthorize(AUTHORITY_ROLE_HR)
	// @PreAuthorize("hasAuthority('ROLE_HR')")
	public Employee onboardNewEmployee(@RequestBody Employee emp) {

		return employeeService.createEmployee(emp);

	}

	@PutMapping("/updateEmployeeRoles")
	@PreAuthorize(AUTHORITY_ROLE_HR)
	public Employee updateEmployeeRoles(@RequestBody Employee employee) {

		return employeeService.updateEmployeeRoles(employee);
	}

	@GetMapping("/{id}")
	// @PreAuthorize("hasAuthority('ROLE_EMPLOYEE')")
	@PreAuthorize(AUTHORITY_ROLE_EMPLOYEE)
	public Employee getEmployeeById(@PathVariable Integer id) {

		return employeeService.getEmployee(id);

	}

	@GetMapping("/all")
	// @PreAuthorize("hasAuthority('ROLE_HR') or hasAuthority('ROLE_MANAGER')")
	@PreAuthorize(AUTHORITY__ROLE_HR_MANAGER)
	public List<Employee> getEmployees() {

		return employeeService.getEmployees();
	}

}