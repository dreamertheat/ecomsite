package ecomsite.java.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	
	/*
	 * @ExceptionHandler(DataAccessException.class) public String
	 * DataAccessHandler(DataAccessException e) { e.printStackTrace(); return
	 * "access_denied"; }
	 */
	
	@ExceptionHandler(AccessDeniedException.class)
	public String AccessDeniedHandler(AccessDeniedException e) {
		e.printStackTrace();
		return "access_denied";
	}
	
}
