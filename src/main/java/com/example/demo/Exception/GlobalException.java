package com.example.demo.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException
{
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> employeeIdNotFound()
	{
		return new ResponseEntity<String>("Employee Id not found", HttpStatus.NOT_FOUND);
	}

}
