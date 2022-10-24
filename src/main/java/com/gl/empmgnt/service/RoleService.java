package com.gl.empmgnt.service;

import java.util.Set;

import com.gl.empmgnt.model.Role;

public interface RoleService {

	Role saveRole(Role role);

	Set<Role> fetchAllRoles();

	Role fetchRoleById(long roleId);

	void deleteRoleById(long roleId);

}
