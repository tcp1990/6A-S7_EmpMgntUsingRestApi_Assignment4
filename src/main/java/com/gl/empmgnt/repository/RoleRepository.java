package com.gl.empmgnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.empmgnt.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
