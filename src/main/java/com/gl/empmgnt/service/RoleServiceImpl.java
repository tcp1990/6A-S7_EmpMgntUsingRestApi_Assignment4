package com.gl.empmgnt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.empmgnt.model.Role;
import com.gl.empmgnt.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role saveRole(Role role) {
		return this.roleRepository.save(role);
	}

	public Set<Role> fetchAllRoles() {
		return new HashSet<>(this.roleRepository.findAll());
	}

	public Role fetchRoleById(long roleId) {
		return this.roleRepository.findById(roleId).orElseThrow();
	}

	public void deleteRoleById(long roleId) {
		this.roleRepository.deleteById(roleId);
	}
}
