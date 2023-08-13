package com.rating.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rating.service.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String msg = ex.getMessage();
		ApiResponse res = ApiResponse.builder().message(msg).httpStaus(HttpStatus.NOT_FOUND).success(true).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
}
