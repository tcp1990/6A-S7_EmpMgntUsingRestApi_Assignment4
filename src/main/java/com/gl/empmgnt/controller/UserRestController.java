package com.gl.empmgnt.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.empmgnt.model.User;
import com.gl.empmgnt.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {
	
	private final UserService userService;

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}

	@GetMapping
	public Set<User> fetchAllUsers() {
		return this.userService.fetchAllUsers();
	}

	@GetMapping("/{id}")
	public User fetchUserById(@PathVariable("id") long userId) {
		return this.userService.fetchUserById(userId);
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") long userId) {
		this.userService.deleteUserById(userId);
	}

}
