package com.user.service.utils;

import org.springframework.http.HttpStatus;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ApiResponse {
	
	private String message;
	private HttpStatus httpStatus;
	private boolean success;
}


