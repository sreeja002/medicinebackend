package com.medicine.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionalHandler {
	@ExceptionHandler(value = {java.util.NoSuchElementException.class})
	public ResponseEntity<?> exceptionHandler(){
	return new ResponseEntity<>("Send Object in Appropriate Formate",HttpStatus.ACCEPTED);
	}

}
