package com.legato.MemberRegistrationPortal.model;

import java.time.LocalDateTime;

public class MyErrorMessage {
	private String message;
	private LocalDateTime now;
	private Exception exType;

	public MyErrorMessage(String message, Exception exType) {
		super();
		this.now = LocalDateTime.now();
		this.message = message;
		this.exType = exType;
	}

	@Override
	public String toString() {
		return "MyErrorMessage [message=" + message + ", now=" + now + ", exType=" + exType + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	public Exception getExType() {
		return exType;
	}

	public void setExType(Exception exType) {
		this.exType = exType;
	}

}
