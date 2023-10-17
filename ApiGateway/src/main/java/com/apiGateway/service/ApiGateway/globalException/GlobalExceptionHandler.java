package com.apiGateway.service.ApiGateway.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.apiGateway.service.ApiGateway.util.GlobalExceptionApiResponse;
import com.apiGateway.service.ApiGateway.util.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<GlobalExceptionApiResponse> userNotFoundExceptionHandler(RuntimeException ex){
		GlobalExceptionApiResponse res = GlobalExceptionApiResponse.builder().message(ex.getMessage()).status(HttpStatus.UNAUTHORIZED).build();
		return new ResponseEntity<>(res,HttpStatus.UNAUTHORIZED);
	}
	
	
}
