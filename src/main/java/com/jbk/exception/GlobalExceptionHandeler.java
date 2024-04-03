package com.jbk.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String>methodArgumentNotValidException(MethodArgumentNotValidException ex , HttpServletRequest request){
		Map<String , String> errorMap = new HashMap<>();
		
		List<FieldError> fieldErrors = ex.getFieldErrors();
		for (FieldError fieldError : fieldErrors)
		{
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		errorMap.put("Path", request.getRequestURI());
		
		return errorMap;
		
	}
	
	@ExceptionHandler(ResourceAlreadyExistException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT)
	public ExceptionResponse resourceAlreadyExistException(ResourceAlreadyExistException ex , HttpServletRequest request) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setMassage(ex.getMessage());
		response.setStatuscode(HttpStatus.CONFLICT);
		response.setTime(LocalDateTime.now());
		return response;
	}
	
	@ExceptionHandler(SomethingWentWrongException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse somethingWentWrongException(SomethingWentWrongException ex , HttpServletRequest request) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setMassage(ex.getMessage());
		response.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR);
		response.setTime(LocalDateTime.now());
		return response;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code=HttpStatus.OK)
	public ExceptionResponse resourceNotFoundException(ResourceNotFoundException ex , HttpServletRequest request) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setMassage(ex.getMessage());
		response.setStatuscode(HttpStatus.NO_CONTENT);
		response.setTime(LocalDateTime.now());
		return response;
	}
	@ExceptionHandler(ResourceNotExistException.class)
	@ResponseStatus(code=HttpStatus.OK)
	public ExceptionResponse resourceNotExistException(ResourceNotExistException ex , HttpServletRequest request) {
		
		ExceptionResponse response = new ExceptionResponse();
		response.setMassage(ex.getMessage());
		response.setStatuscode(HttpStatus.NO_CONTENT);
		response.setTime(LocalDateTime.now());
		return response;
	}
	
}
