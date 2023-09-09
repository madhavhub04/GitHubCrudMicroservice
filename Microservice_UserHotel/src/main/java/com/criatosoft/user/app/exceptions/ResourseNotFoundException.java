package com.criatosoft.user.app.exceptions;

public class ResourseNotFoundException extends RuntimeException{

	public ResourseNotFoundException() {
		super("On server UserId not found...!!!");
	}
	
	public ResourseNotFoundException(String message) {
		super(message);
	}
}
