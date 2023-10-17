package com.jwt3.Authorization.auth.controllers;



import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt3.Authorization.auth.Util.Kmessage;
import com.jwt3.Authorization.auth.entity.Users;
import com.jwt3.Authorization.auth.service.impl.UserServiceImpl;
import com.jwt3.Authorization.auth.utils.AuthRequest;
import com.jwt3.Authorization.auth.utils.AuthResponse;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private UserServiceImpl userService;
	
	@Value("${spring.kafka.topic.name}")
	private String topic;
	
	@Autowired
	private DaoAuthenticationProvider authManager;
	
	@PostMapping("/register")
	public ResponseEntity<Users> saveUser(@RequestBody Users user){
		Users usr  = userService.saveUser(user);
		Kmessage msg = new Kmessage();
		msg.setEmail(user.getEmail());
		msg.setName(user.getName());
		msg.setMsg("user creation is done");
		userService.sendMessageToKafka(topic, msg);
		return new ResponseEntity<>(usr,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/token")
	public ResponseEntity<?> getToken(@RequestBody AuthRequest req){
		logger.info("inside auth request with body: " + req);
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUserName(), req.getPassword(),null));
		if(auth.isAuthenticated()) {
			logger.info("authentication successfull");
		String token = userService.getToken(req.getUserName());
		Claims claims = userService.getClaims(token);
		//System.out.println(claims);
		AuthResponse res = AuthResponse.builder().token(token).creationTime(new Date()).expiryTime(claims.getExpiration()).build();
		return new ResponseEntity<>(res,HttpStatus.OK);
		}else {
			logger.info("in else part");
			return new ResponseEntity<>("auth failed",HttpStatus.UNAUTHORIZED);
		}
		}
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
}
