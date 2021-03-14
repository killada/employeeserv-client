package com.paypal.bfs.test.employee.utils;

import java.util.Calendar;

import com.paypal.bfs.test.employee.constants.GenericConstants;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

public class Utility {
	
	public Employee populateEmployee() {
		Employee mockEmp  = new Employee();
		mockEmp.setId(1);
		mockEmp.setFirstName(GenericConstants.FIRST_NAME);
		mockEmp.setLastName(GenericConstants.LAST_NAME);
		mockEmp.setDateOfBirth(GenericConstants.DATE_OF_BIRTH);
		mockEmp.setLine1(GenericConstants.ADDRESS_LINE_1);
		mockEmp.setLine2(GenericConstants.ADDRESS_LINE_2);
		mockEmp.setCity(GenericConstants.CITY);
		mockEmp.setState(GenericConstants.STATE);
		mockEmp.setCountry(GenericConstants.COUNTRY);
		mockEmp.setZipCode(GenericConstants.ZIP_CODE);
		return mockEmp;
	}
	
	public com.paypal.bfs.test.employee.model.Employee populateEmployeeEntity() {
		com.paypal.bfs.test.employee.model.Employee mockEmp  = new com.paypal.bfs.test.employee.model.Employee();
		mockEmp.setEmployeeId(1);
		mockEmp.setFirstName(GenericConstants.FIRST_NAME);
		mockEmp.setLastName(GenericConstants.LAST_NAME);
		mockEmp.setDateOfBirth(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		mockEmp.setAddressLine1(GenericConstants.ADDRESS_LINE_1);
		mockEmp.setAddressLine2(GenericConstants.ADDRESS_LINE_2);
		mockEmp.setCity(GenericConstants.CITY);
		mockEmp.setState(GenericConstants.STATE);
		mockEmp.setCountry(GenericConstants.COUNTRY);
		mockEmp.setZipCode(GenericConstants.ZIP_CODE);
		return mockEmp;
	}

}
