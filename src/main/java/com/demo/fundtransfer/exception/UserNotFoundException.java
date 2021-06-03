package com.demo.fundtransfer.exception;

public class UserNotFoundException extends RuntimeException {

	
	/**
	 * Prajakta Joshi
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
