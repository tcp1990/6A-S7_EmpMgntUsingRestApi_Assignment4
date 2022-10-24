package com.gl.empmgnt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.empmgnt.model.Employee;
import com.gl.empmgnt.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	public Set<Employee> fetchAllEmployees() {
		return new HashSet<>(this.employeeRepository.findAll());
	}

	public Set<Employee> fetchAllEmployeesByFirstName(String firstName) {
		return this.employeeRepository.findAllByFirstName(firstName);
	}

	public Employee fetchEmployeeById(long empId) {
		return this.employeeRepository.findById(empId).orElseThrow();
	}

	public void deleteEmployeeById(long empId) {
		this.employeeRepository.deleteById(empId);
	}
}
