package com.demo.fundtransfer.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Generic Exception......<<<<<<<<<Testing");

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {

		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
		System.out.println("In usernot found method");

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> accountexception(AccountNotFoundException exception) {

		ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		System.out.println("In Account not found method");

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CommonException.class)
	public ResponseEntity<Object> commonexception(CommonException exception) {

		ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		System.out.println("In Account not found method");

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((err) -> {
			map.put(((FieldError) err).getField(), err.getDefaultMessage());
		});

		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

}
