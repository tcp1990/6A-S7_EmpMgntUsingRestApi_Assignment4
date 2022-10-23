package com.gl.empmgnt.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.gl.empmgnt.model.Employee;
import com.gl.empmgnt.model.Role;
import com.gl.empmgnt.model.User;
import com.gl.empmgnt.repository.EmployeeRepository;
import com.gl.empmgnt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {

	private final EmployeeRepository employeeRepository;
	private final UserRepository userRepository;
	
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
		
		Role userRole = new Role();
		userRole.setRoleName("USER");
		
		Role adminRole = new Role();
		adminRole.setRoleName("ADMIN");
		
		Role managerRole = new Role();
		managerRole.setRoleName("MANAGER");
		
		User vinayUserObj = new User();
		vinayUserObj.setUsername("vinay");
		vinayUserObj.setPassword("welcome");
		vinayUserObj.setEmailAddress("vinay@gmail.com");
		vinayUserObj.addRole(adminRole);
		this.userRepository.save(vinayUserObj);
		
		User rakeshUserObj = new User();
		rakeshUserObj.setUsername("rakesh");
		rakeshUserObj.setPassword("welcome");
		rakeshUserObj.setEmailAddress("rakesh@gmail.com");
		rakeshUserObj.addRole(managerRole);
		this.userRepository.save(rakeshUserObj);

		User kiranUserObj = new User();
		kiranUserObj.setUsername("kiran");
		kiranUserObj.setPassword("welcome");
		kiranUserObj.setEmailAddress("kiran@gmail.com");
		kiranUserObj.addRole(userRole);
		this.userRepository.save(kiranUserObj);

	}
}
