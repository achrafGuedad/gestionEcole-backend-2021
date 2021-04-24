package com.project.Pfe.Pfe.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionController {

	
	@ExceptionHandler(value = ApiRuntimeException.class)
	   public ResponseEntity<Object> exception(ApiRuntimeException exception) {
	      return new ResponseEntity<>("not foundddddd", HttpStatus.NOT_FOUND);
	   }
	






}
