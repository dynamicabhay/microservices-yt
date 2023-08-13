package com.user.service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.services.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user){
		User usr = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(usr);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable String userId){
		User usr = userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body(usr);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		List<User> usrs = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(usrs);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUserbyId(@RequestBody User user){
		User usr = userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(usr);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable String userId){
		userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
	}
	
}
