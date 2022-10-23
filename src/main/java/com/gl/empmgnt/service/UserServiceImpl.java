package com.gl.empmgnt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.empmgnt.model.User;
import com.gl.empmgnt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	public Set<User> fetchAllUsers() {
		return new HashSet<>(this.userRepository.findAll());
	}

	public User fetchUserById(long userId) {
		return this.userRepository.findById(userId).orElseThrow();
	}

	public void deleteUserById(long userId) {
		this.userRepository.deleteById(userId);
	}
}
