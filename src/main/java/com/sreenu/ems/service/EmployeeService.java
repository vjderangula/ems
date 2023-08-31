package com.sreenu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sreenu.ems.entity.Employee;
import com.sreenu.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private static final String DEFAULT_ROLE = "ROLE_EMPLOYEE";

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Employee createEmployee(Employee employee) {

		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		employee.setRoles(DEFAULT_ROLE);
		return employeeRepository.save(employee);
	}

	public Employee getEmployee(Integer id) {

		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found " + id));

	}

	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}
	
	public Employee updateEmployeeRoles(Employee employee) {
		Employee existingEmployee = getEmployee(employee.getId());
		existingEmployee.setRoles(employee.getRoles());
		return employeeRepository.save(employee);
	}
}
