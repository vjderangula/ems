package com.sreenu.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sreenu.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
