package com.rakesh.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.crud.dao.EmployeeRepository;
import com.rakesh.crud.dto.Employee;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired(required=true)
	EmployeeRepository repo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public List<Employee> listAllEmployees() {
		return repo.findAll();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Employee> get(Integer id) {
		return repo.findById(id);
	}

}
