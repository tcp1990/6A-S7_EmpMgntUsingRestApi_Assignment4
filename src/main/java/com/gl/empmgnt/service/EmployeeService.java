package com.gl.empmgnt.service;

import java.util.List;
import java.util.Set;

import com.gl.empmgnt.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Set<Employee> fetchAllEmployees();

	Set<Employee> fetchAllEmployeesByFirstName(String firstName);
	
	List<Employee> fetchAllEmployeesInSortedOrderByFirstName(String sortingType);

	Employee fetchEmployeeById(long empId);

	void deleteEmployeeById(long empId);
}
