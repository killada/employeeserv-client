package com.paypal.bfs.test.employe.exception;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.paypal.bfs.test.employee.constants.GenericConstants;

@RestControllerAdvice
public class EmployeeExceptionsHandler {
	
	/* When any Annotated constraints fail for the input request */
	
	  @ExceptionHandler(MethodArgumentNotValidException.class) 
	  public ResponseEntity<EmployeeError> validationError(MethodArgumentNotValidException ex) { 
		  BindingResult result = ex.getBindingResult(); 
		  final List<FieldError> fieldErrors = result.getFieldErrors(); 
		  StringBuilder builder = new StringBuilder(); 
		  for (FieldError error : fieldErrors) {
		  builder.append("Employee.");
		  builder.append(error.getField());
		  builder.append(" : ");
		  builder.append(error.getDefaultMessage());
		  builder.append(", ");   
		  }
	  
		  EmployeeError error = new EmployeeError(); 
		  error.setStatus(400);
		  error.setError("Bad Request");
		  error.setMessage(builder.toString());
		  error.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		  return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	  }
	  /* Bad Request Exceptions are handled */
	  @ExceptionHandler(BadRequestException.class) 
	  public ResponseEntity<EmployeeError> badRequestError(BadRequestException ex){
		  EmployeeError error = new EmployeeError(); 
		  error.setStatus(400);
		  error.setError("Bad Request");
		  error.setMessage(ex.getMessage());
		  error.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		  return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	  }
	  
	  /* EntityNotFoundExceptions are handled  */
	  @ExceptionHandler(EntityNotFoundException.class) 
	  public ResponseEntity<EmployeeError> notFound(EntityNotFoundException ex){
		  EmployeeError error = new EmployeeError(); 
		  String errorMsg = "";
		  error.setStatus(404);
		  error.setError("Resource not found");
		  if(ex.getMessage().contains(GenericConstants.EMPLOYEE_ENTITY))
		  {
			  errorMsg = ex.getMessage().replace(GenericConstants.EMPLOYEE_ENTITY, "Employee");
			  error.setMessage(errorMsg);
		  }else {
			  error.setMessage(ex.getMessage());
		  }
		  error.setTimestamp(new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
		  return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	  }

}
