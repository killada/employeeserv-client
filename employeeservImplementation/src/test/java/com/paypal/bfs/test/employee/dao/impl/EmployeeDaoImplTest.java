package com.paypal.bfs.test.employee.dao.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.test.employee.repository.EmployeeRepository;
import com.paypal.bfs.test.employee.utils.Utility;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {EmployeeDaoImpl.class})
public class EmployeeDaoImplTest {
	
	@InjectMocks
	private EmployeeDaoImpl employeeDaoImpl;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	private Utility utility;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		utility = new Utility();
	    
	 }
	
	@Test
	public void getEmployeeTest() {
		 
		 Mockito.when(employeeRepository.getOne(Mockito.anyInt())).thenReturn(utility.populateEmployeeEntity());
		 Employee emp =employeeDaoImpl.getEmployee(1);
		 Assert.assertNotNull(emp);
		
	}
	
	@Test
	public void saveEmployeeTest() {
		 
		 Mockito.when(employeeRepository.save(Mockito.any(com.paypal.bfs.test.employee.model.Employee.class))).thenReturn(utility.populateEmployeeEntity());
		 Employee emp =employeeDaoImpl.saveEmployee(utility.populateEmployee());
		 Assert.assertNotNull(emp);
		
	}



}
