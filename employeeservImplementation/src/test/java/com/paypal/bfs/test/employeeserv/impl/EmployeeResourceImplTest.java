package com.paypal.bfs.test.employeeserv.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.paypal.bfs.test.employee.dao.impl.EmployeeDaoImpl;
import com.paypal.bfs.test.employee.utils.Utility;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeResourceImplTest {
	
	
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeDaoImpl employeeDaoImpl;
	
	@InjectMocks
	private EmployeeResourceImpl employeeResourceImpl;
	
	@Autowired
	private WebApplicationContext wc;
	
	private Utility utility;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	    mockMvc = MockMvcBuilders.webAppContextSetup(this.wc).build();
	    utility = new Utility();
	    
	 }
	
	@Test
	public void getControllerEmployeeGetByIdTest() throws Exception {
		
		Mockito.when(employeeDaoImpl.getEmployee(Mockito.anyInt())).thenReturn(utility.populateEmployee());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/bfs/employees/1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals(200, result.getResponse().getStatus());
		
	}

	@Test
	public void postControllerCreateEmployeeTest() throws Exception {
		String employeeRequest = "{\"first_name\":\"Kevin\",\"last_name\":\"Pearson\",\"date_of_birth\":\"2020-10-15\",\"line1\":\"MIG-B\",\"city\":\"Hyd\",\"state\":\"Telengna\",\"country\":\"India\",\"zip_code\":\"530051\"}";
		Mockito.when(employeeDaoImpl.saveEmployee(Mockito.any(Employee.class))).thenReturn(utility.populateEmployee());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/bfs/createEmployee").accept(MediaType.APPLICATION_JSON).content(employeeRequest).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals(201, result.getResponse().getStatus());
		
	}
	
	
	
	

}
