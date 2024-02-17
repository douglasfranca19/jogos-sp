package com.doufsp.jogossp.exceptions.manipula;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.doufsp.jogossp.dto.ErrorDto;
import com.doufsp.jogossp.exceptions.IdNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipularExceptions {

	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ErrorDto> IdNotFound(IdNotFound e, HttpServletRequest request) {

		ErrorDto error = new ErrorDto(Instant.now(), 404, "Id não encontrado na base de dados", request.getRequestURI(),
				e.getMessage());

		return ResponseEntity.status(404).body(error);
	}

}
