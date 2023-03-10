package com.iktpreobuka.elektronskiDnevnik.controllers.error;

public class RESTError {

	public Integer code;
	
	public String message;
	
	public RESTError() {
		super();
	}

	public RESTError(Integer code, String message) {
		
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}