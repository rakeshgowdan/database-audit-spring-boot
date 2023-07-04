package com.rakesh.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.crud.dto.Employee;
import com.rakesh.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/get-all-employees")
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployeelist = service.listAllEmployees();
		return allEmployeelist;
	}

	@GetMapping("/get-employee/{id}")
	public Optional<Employee> getEmployeebyId(@PathVariable(value = "id") Integer employeeId)
	{
		Optional<Employee> employeeEntity = service.get(employeeId);
		return employeeEntity;
	}
	@PostMapping("/add-employee")
    public Employee createEmployee(@RequestBody Employee employee) {
    	 Employee savedEmployee = service.saveEmployee(employee);
    	 return savedEmployee;
    }
	@DeleteMapping("/delete-employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
    {
		Employee employee = service.get(employeeId).get();

        service.delete(employee.getEmployee_id());
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	@PutMapping("/update-employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
         @RequestBody Employee employeeDetails) {
        Employee employee = service.get(employeeId).get();

        employee.setEmployee_name(employeeDetails.getEmployee_name());
        final Employee updatedEmployee = service.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
