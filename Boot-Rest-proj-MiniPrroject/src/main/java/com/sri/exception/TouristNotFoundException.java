package com.sri.exception;

public class TouristNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public TouristNotFoundException(String msg){	
		super(msg);
	}
	
	public TouristNotFoundException() {
		super();
	}
}
