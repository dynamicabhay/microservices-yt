package com.jwt3.Authorization.auth.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt3.Authorization.auth.Util.Kmessage;
import com.jwt3.Authorization.auth.entity.Users;
import com.jwt3.Authorization.auth.repositories.UserRepository;
import com.jwt3.Authorization.auth.service.UserService;
import com.jwt3.Authorization.auth.utils.JwtUtil;

import io.jsonwebtoken.Claims;

@Service
public class UserServiceImpl implements UserService {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private  UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwtService;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Override
	public Users saveUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
	
		return userRepo.findAll();
	}
	
	public String getToken(String userName) {
		System.out.println("userName +> " + userName );
		return jwtService.generateToken(userName);
	}
	
	public Claims getClaims(String token) {
		return jwtService.validateToken(token);
	}
	
	public void sendMessageToKafka(String topicName, Kmessage message) {
	    kafkaTemplate.send(topicName,message);
	    logger.info("message sended to kafka successfully");
	  }
	
	
}
