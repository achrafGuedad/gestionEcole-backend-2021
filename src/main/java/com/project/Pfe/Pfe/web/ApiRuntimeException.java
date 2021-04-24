package com.project.Pfe.Pfe.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiRuntimeException  extends RuntimeException {

	public ApiRuntimeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
