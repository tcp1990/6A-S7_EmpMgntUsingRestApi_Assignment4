package com.gl.empmgnt.service;

import java.util.Set;

import com.gl.empmgnt.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Set<Employee> fetchAllEmployees();

	Set<Employee> fetchEmployeeByFirstName(String firstName);

	Employee fetchEmployeeById(long empId);

	void deleteEmployeeById(long empId);
}
