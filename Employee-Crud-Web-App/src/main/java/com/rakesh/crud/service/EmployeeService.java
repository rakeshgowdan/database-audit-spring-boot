package com.rakesh.crud.service;

import java.util.List;
import java.util.Optional;

import com.rakesh.crud.dto.Employee;


public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> listAllEmployees();
	public void delete(Integer id);
	public Optional<Employee> get(Integer id);
	
	
}
