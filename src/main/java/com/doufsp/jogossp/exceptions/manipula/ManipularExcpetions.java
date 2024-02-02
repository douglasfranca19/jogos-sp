package com.doufsp.jogossp.exceptions.manipula;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.doufsp.jogossp.exceptions.IdNotFound;

@ControllerAdvice
public class ManipularExcpetions {

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<String> IdNotFound(IdNotFound e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

}
