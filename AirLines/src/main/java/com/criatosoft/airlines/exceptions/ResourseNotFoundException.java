package com.criatosoft.airlines.exceptions;

public class ResourseNotFoundException extends RuntimeException{
	
	public ResourseNotFoundException() {
		super("Resource Not Found Exception ...!!");
	}
	public ResourseNotFoundException(String massage) {
		super(massage);
	}

}
