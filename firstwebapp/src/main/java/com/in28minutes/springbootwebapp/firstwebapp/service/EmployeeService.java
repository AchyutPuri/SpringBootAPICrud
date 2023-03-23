package com.in28minutes.springbootwebapp.firstwebapp.service;

import java.util.List;

import com.in28minutes.springbootwebapp.firstwebapp.model.Employee;


public interface EmployeeService {

public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void deleteById(int theId);
}
