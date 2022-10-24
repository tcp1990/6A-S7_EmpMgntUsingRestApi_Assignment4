package com.gl.empmgnt.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.empmgnt.model.Role;
import com.gl.empmgnt.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleRestController {

	private final RoleService roleService;

	@PostMapping
	public Role saveRole(@RequestBody Role role) {
		return this.roleService.saveRole(role);
	}

	@GetMapping
	public Set<Role> fetchAllRoles() {
		return this.roleService.fetchAllRoles();
	}

	@GetMapping("/{id}")
	public Role fetchRoleById(@PathVariable("id") long roleId) {
		return this.roleService.fetchRoleById(roleId);
	}

	@DeleteMapping("/{id}")
	public void deleteRoleById(@PathVariable("id") long roleId) {
		this.roleService.deleteRoleById(roleId);
	}

}
