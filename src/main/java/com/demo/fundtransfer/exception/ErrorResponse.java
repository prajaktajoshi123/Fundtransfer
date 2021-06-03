package com.demo.fundtransfer.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	// private LocalDateTime timestamp;
	private String message;
	// private String detailes;
	private HttpStatus httpCodeMessage;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message, HttpStatus httpCodeMessage) {
		super();
		// this.timestamp = timestamp;
		this.message = message;
		this.httpCodeMessage = httpCodeMessage;
	}

	/*
	 * public ErrorResponse(LocalDateTime timestamp, String message, String
	 * detailes, HttpStatus httpCodeMessage) { super(); this.timestamp = timestamp;
	 * this.message = message; this.detailes = detailes; this.httpCodeMessage =
	 * httpCodeMessage; }
	 */

	/*
	 * public LocalDateTime getTimestamp() { return timestamp; }
	 * 
	 * public void setTimestamp(LocalDateTime timestamp) { this.timestamp =
	 * timestamp; }
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * public String getDetailes() { return detailes; }
	 * 
	 * public void setDetailes(String detailes) { this.detailes = detailes; }
	 */

	public HttpStatus getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public void setHttpCodeMessage(HttpStatus httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}

}
