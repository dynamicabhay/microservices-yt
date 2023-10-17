package com.jwt3.Authorization.auth.utils;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthResponse {

	private String token;
	private Date creationTime;
	private Date expiryTime;
}
