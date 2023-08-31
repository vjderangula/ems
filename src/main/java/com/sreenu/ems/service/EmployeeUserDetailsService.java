package com.sreenu.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sreenu.ems.entity.Employee;
import com.sreenu.ems.repository.EmployeeRepository;

public class EmployeeUserDetailsService implements UserDetailsService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	Optional<Employee>	employee = employeeRepository.findByUserName(username);
	
		return employee.map(EmployeeUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException(username + " not found in db"));
	}

}
