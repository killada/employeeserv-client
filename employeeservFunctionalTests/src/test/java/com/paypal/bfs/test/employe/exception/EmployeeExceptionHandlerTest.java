package com.paypal.bfs.test.employe.exception;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {EmployeeExceptionsHandler.class})
public class EmployeeExceptionHandlerTest {
	
	@InjectMocks
	private EmployeeExceptionsHandler employeeExceptionsHandler;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	    
	 }
	
	@Test
	public void validationError() throws NoSuchMethodException, SecurityException {
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(new Employee(), "testBean"); 
		errors.rejectValue("firstName", "invalid"); 
		MethodParameter parameter = Mockito.mock(MethodParameter.class);
		//MethodParameter parameter = new MethodParameter(this.getClass().getMethod("handle", String. class), 0);
		MethodArgumentNotValidException ex = new MethodArgumentNotValidException(parameter,errors);
		ResponseEntity<EmployeeError> empError =employeeExceptionsHandler.validationError(ex);
		Assert.assertEquals(400, empError.getStatusCodeValue());
		
	}
	
	@Test
	public void badRequestExceptionTest() {
		
		ResponseEntity<EmployeeError> empError =employeeExceptionsHandler.badRequestError(new BadRequestException("Date should be of the format yyyy-MM-dd"));
		Assert.assertEquals(400, empError.getStatusCodeValue());
	}
	
	@Test
	public void entityNotFoundExceptionTest() {
		
		ResponseEntity<EmployeeError> empError =employeeExceptionsHandler.notFound(new EntityNotFoundException("Employee with id 1 not found"));
		Assert.assertEquals(404, empError.getStatusCodeValue());
	}

	
	
}
