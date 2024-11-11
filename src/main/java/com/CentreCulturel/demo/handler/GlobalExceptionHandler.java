package com.CentreCulturel.demo.handler;

import java.util.HashSet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.CentreCulturel.demo.Exception.UtilisateurAssignementException;

import jakarta.persistence.EntityNotFoundException;



@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse> handelException(MethodArgumentNotValidException exp){

		var validationErrors=new HashSet<String>();
		for(ObjectError error : exp.getBindingResult().getAllErrors()) {
            var errorMsg = error.getDefaultMessage();
            validationErrors.add(String.format("%s", errorMsg));
        }
		var errorResponse =ErrorResponse.builder()
				.errorMessage("Object not valid")
				.validationErrors(validationErrors)
				.build();
		
		     return ResponseEntity
	                .badRequest()
	                .body(errorResponse);
}
	 @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleException(EntityNotFoundException exp) {
	        var errorResponse = ErrorResponse.builder()
	                .errorMessage(exp.getMessage())
	                .build();
	        return ResponseEntity
	                .status(HttpStatus.NOT_ACCEPTABLE)
	                .body(errorResponse);
	    }
	 @ExceptionHandler(MaxUploadSizeExceededException.class)
	    public ResponseEntity<ErrorResponse> handleException(MaxUploadSizeExceededException exp) {
	        var errorResponse = ErrorResponse.builder()
	                .errorMessage(exp.getMessage())
	                .build();
	        return ResponseEntity
	                .status(HttpStatus.NOT_ACCEPTABLE)
	                .body(errorResponse);
	    }
	 @ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException exp) {
	        var errorResponse = ErrorResponse.builder()
	                .errorMessage(exp.getMessage())
	                .build();
	        return ResponseEntity
	                .status(HttpStatus.NOT_ACCEPTABLE)
	                .body(errorResponse);
	    }
	@ExceptionHandler(UtilisateurAssignementException.class)
	public ResponseEntity<ErrorResponse> handleException(UtilisateurAssignementException exp){
		var errorResponse=ErrorResponse.builder()
				.errorMessage(exp.getMessage())
				.build();
		return ResponseEntity
				.badRequest()
				.body(errorResponse);
	}
}