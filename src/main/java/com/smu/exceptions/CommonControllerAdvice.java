package com.smu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice(basePackages = "com.smu.controller")
public class CommonControllerAdvice {

	@ExceptionHandler(MyRuntimeException.class)
	ResponseEntity<ApiExceptionResponse> handleRegistrationException(MyRuntimeException exception) {

		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getErrorMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());

		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
