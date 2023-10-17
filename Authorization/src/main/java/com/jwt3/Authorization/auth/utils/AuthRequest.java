package com.jwt3.Authorization.auth.utils;

import lombok.Data;

@Data
public class AuthRequest {

	private String userName;
	private String password;
}
