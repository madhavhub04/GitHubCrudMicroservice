package com.criatosoft.user.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ApiError> handlerResourseNotFoundException(ResourseNotFoundException ex){
		
		String message = ex.getMessage();
		ApiError response = ApiError.builder()
			.message(message)
			.success(true)
			.status(HttpStatus.NOT_FOUND)
			.build();
		 
		return new ResponseEntity<ApiError>(response,HttpStatus.NOT_FOUND);
		
	}

}
