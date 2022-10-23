package com.gl.empmgnt.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DomainUserDetails implements UserDetails {

	private User user;

	public DomainUserDetails(User user) {
		this.user.setUsername(user.getUsername());
		this.user.setPassword(user.getPassword());
		this.user.setRoles(user.getRoles());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<>();
		var roles = this.user.getRoles();
		for (Role role : roles) {
			String roleName = role.getRoleName();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);
			authorities.add(authority);
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
