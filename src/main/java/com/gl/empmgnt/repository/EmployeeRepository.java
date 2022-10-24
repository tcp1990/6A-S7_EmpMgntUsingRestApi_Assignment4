package com.gl.empmgnt.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.empmgnt.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Set<Employee> findAllByFirstName(String firstName);
}
