package com.jwt3.Authorization.auth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt3.Authorization.auth.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByEmail(String email);
}
