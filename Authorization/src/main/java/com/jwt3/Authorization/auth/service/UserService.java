package com.jwt3.Authorization.auth.service;

import java.util.List;

import com.jwt3.Authorization.auth.entity.Users;

public interface UserService {

	public Users saveUser(Users user);
	
	public List<Users> getAllUsers();
	
}
