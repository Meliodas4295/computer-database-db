package com.excilys.training.web.exception;

public class EmptyNameException extends ComputerException{

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
