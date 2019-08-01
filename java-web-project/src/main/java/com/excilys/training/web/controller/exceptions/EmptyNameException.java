package com.excilys.training.web.controller.exceptions;

public class EmptyNameException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyNameException() {
		super();
	}
	
	public EmptyNameException(String message) {
		super(message);
	}
}
