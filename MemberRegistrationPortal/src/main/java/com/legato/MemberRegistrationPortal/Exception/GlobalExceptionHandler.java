package com.legato.MemberRegistrationPortal.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.legato.MemberRegistrationPortal.model.MyErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MemberRegistrationPortalException.class)
	public ResponseEntity<MyErrorMessage> handleMovieException(MemberRegistrationPortalException me) {
		return new ResponseEntity<>(new MyErrorMessage(me.getMessage(), me), HttpStatus.OK);
	}

}