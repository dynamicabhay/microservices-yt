package com.user.service.services;

import java.util.List;

import com.user.service.entities.User;

public interface UserService {

	// get all users
	 public List<User> getAllUsers();
	 
	 
	 // get unique user based on id
	 public User getUser(String id);
	 
	 
	 //create 
	public  User saveUser(User user);
	 
	 // delete user
	public void deleteUser(String id);
	 
	 // update user
	 User updateUser(User user);
	
	
}
