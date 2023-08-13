package com.hotel.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.service.utils.ApiResponse;

@RestControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String msg = ex.getMessage();
		ApiResponse res = ApiResponse.builder().message(msg).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
}
