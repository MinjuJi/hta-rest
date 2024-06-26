package com.sample.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sample.rest.RestResponse;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(RuntimeException.class)
	public RestResponse<Void> handleRuntimeException(RuntimeException ex){
		return RestResponse.getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
}
