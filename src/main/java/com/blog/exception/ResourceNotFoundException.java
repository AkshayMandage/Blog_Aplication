package com.blog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourseName;
	String fildname;	
	long fieldValue;

	public ResourceNotFoundException(String resourseName, String fildname, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourseName, fildname, fieldValue));
		this.resourseName = resourseName;
		this.fildname = fildname;
		this.fieldValue = fieldValue;
	}
}
