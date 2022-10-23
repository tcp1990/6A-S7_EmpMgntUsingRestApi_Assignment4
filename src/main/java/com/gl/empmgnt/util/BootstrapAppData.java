package com.gl.empmgnt.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.gl.empmgnt.model.Employee;
import com.gl.empmgnt.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

	private final EmployeeRepository employeeRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployees(ApplicationReadyEvent event) {
		
		Employee dhineshEmpObj = new Employee();
		dhineshEmpObj.setFirstName("DhineshBabu");
		dhineshEmpObj.setLastName("Selvam");
		dhineshEmpObj.setEmailAddress("dhineshbabu@gmail.com");
		this.employeeRepository.save(dhineshEmpObj);
		
		Employee anandEmpObj = new Employee();
		anandEmpObj.setFirstName("AnandKumar");
		anandEmpObj.setLastName("Mani");
		anandEmpObj.setEmailAddress("anandkumar@gmail.com");
		this.employeeRepository.save(anandEmpObj);
		
		Employee samEmpObj = new Employee();
		samEmpObj.setFirstName("SamNithyananth");
		samEmpObj.setLastName("Chandran");
		samEmpObj.setEmailAddress("samnithyananth@gmail.com");
		this.employeeRepository.save(samEmpObj);
		
		Employee karthickEmpObj = new Employee();
		karthickEmpObj.setFirstName("KarthickRaja");
		karthickEmpObj.setLastName("Ramasamy");
		karthickEmpObj.setEmailAddress("karthickraja@gmail.com");
		this.employeeRepository.save(karthickEmpObj);
	}
}
