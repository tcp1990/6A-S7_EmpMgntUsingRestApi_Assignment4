package com.gl.empmgnt.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.empmgnt.model.Employee;
import com.gl.empmgnt.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeRestController {

	private final EmployeeService employeeService;

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.saveEmployee(employee);
	}

	@GetMapping
	public Set<Employee> fetchAllEmployees() {
		return this.employeeService.fetchAllEmployees();
	}

	@GetMapping("/search/{firstName}")
	public Set<Employee> fetchEmployeeByFirstName(@PathVariable("firstName") String firstName) {
		return this.employeeService.fetchEmployeeByFirstName(firstName);
	}

	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") long empId) {
		return this.employeeService.fetchEmployeeById(empId);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable("id") long empId) {
		this.employeeService.deleteEmployeeById(empId);
	}

}
