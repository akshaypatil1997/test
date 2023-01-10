package com.neosoft.exception.handling.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.neosoft.exception.handling.dto.UserNotFoundException;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub

		Map<String, String> error = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(e -> error.put(e.getField(), e.getDefaultMessage()));

		return new ResponseEntity<Object>(error,status.BAD_REQUEST);

	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<Object>("please check http method",status.METHOD_NOT_ALLOWED);
		
	}
	

	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> userNotfound(UserNotFoundException ex) {

		Map<String, String> err = new HashMap<String, String>();
		err.put("error", ex.getMessage());

		return err;

	}

}
