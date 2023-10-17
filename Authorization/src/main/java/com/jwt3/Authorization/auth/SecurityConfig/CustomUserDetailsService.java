package com.jwt3.Authorization.auth.SecurityConfig;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jwt3.Authorization.auth.entity.Users;
import com.jwt3.Authorization.auth.repositories.UserRepository;
import com.jwt3.Authorization.auth.utils.CustomUserDetails;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<Users> usr = 	userRepo.findByEmail(email);
	//usr.map(CustomUserDetails::new).orElseThrow(() -> new RuntimeException("usr not foudn") );
	CustomUserDetails res = usr.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user with email " + email + " is not present"));
	logger.info("customerUserDetails => " + res);
	return res;
		
	}

}
