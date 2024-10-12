package com.restaurant.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setDetails(ex.getMessage());
		exceptionResponse.setHttpCodeMessage(HttpStatus.BAD_REQUEST.name());
		exceptionResponse.setTimestamp(LocalDate.now());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BookTableInvalidException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(BookTableInvalidException ex,
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setDetails(ex.getMessage());
		exceptionResponse.setHttpCodeMessage(HttpStatus.BAD_REQUEST.name());
		exceptionResponse.setTimestamp(LocalDate.now());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		exceptionResponse.setDetails(ex.getBindingResult().getFieldError().getDefaultMessage());
		exceptionResponse.setHttpCodeMessage(HttpStatus.BAD_REQUEST.name());
		exceptionResponse.setTimestamp(LocalDate.now());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
