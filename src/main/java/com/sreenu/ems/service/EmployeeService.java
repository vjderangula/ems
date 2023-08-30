package com.sreenu.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sreenu.ems.entity.Employee;
import com.sreenu.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee createEmployee(Employee emp) {
		
		return employeeRepository.save(emp);
	}
public Employee getEmployee(Integer id){
	
		
		return employeeRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Employee not found "+id));
				
	}
	
	public List<Employee> getEmployees(){
		
		return employeeRepository.findAll();
	}
	

}
