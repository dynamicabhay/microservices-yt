package com.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.utils.ApiResponse;




@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // this annotation is telling to handle the ResourceNotFoundException through out the project
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse resp  = ApiResponse.builder().message(message).httpStatus(HttpStatus.NOT_FOUND).success(true).build();
	return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
}
}
