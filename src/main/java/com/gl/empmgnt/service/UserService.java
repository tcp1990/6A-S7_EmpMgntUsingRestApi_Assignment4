package com.gl.empmgnt.service;

import java.util.Set;

import com.gl.empmgnt.model.User;

public interface UserService {

	User saveUser(User user);

	Set<User> fetchAllUsers();

	User fetchUserById(long userId);

	void deleteUserById(long userId);

}
