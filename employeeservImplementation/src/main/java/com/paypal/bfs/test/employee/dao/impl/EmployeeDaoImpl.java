package com.paypal.bfs.test.employee.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.BadRequestException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paypal.bfs.test.employee.constants.GenericConstants;
import com.paypal.bfs.test.employee.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.model.Employee;


@Component
public class EmployeeDaoImpl {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	private static Logger log = LogManager.getLogger(EmployeeDaoImpl.class);
	
	public Employee getEmployee(int empId) {
		
		com.paypal.bfs.test.employee.model.Employee emp = employeeRepository.getOne(Integer.valueOf(empId));
		return populateEmployeeData(emp);        
	}
	//parsing date to String
	private String getStringFromDate(Date dateOfBirth) {
		DateFormat parser = new SimpleDateFormat(GenericConstants.DATE_FORMAT);	
		return parser.format(dateOfBirth);
	}

	public Employee saveEmployee(Employee employee) {
		
		com.paypal.bfs.test.employee.model.Employee emp = new com.paypal.bfs.test.employee.model.Employee();
		
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());        
        emp.setDateOfBirth(validateDOB(employee.getDateOfBirth()));
        emp.setAddressLine1(employee.getLine1());
        emp.setAddressLine2(employee.getLine2());
        emp.setCity(employee.getCity());
        emp.setState(employee.getState());
        emp.setCountry(employee.getCountry());
        emp.setZipCode(employee.getZipCode());
        return populateEmployeeData(employeeRepository.save(emp));
        
        
	}
	
	//Method to populate the employee Data
	private Employee populateEmployeeData(com.paypal.bfs.test.employee.model.Employee emp) {
		Employee employee = new Employee();
		employee.setId(emp.getEmployeeId());
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setDateOfBirth(getStringFromDate(emp.getDateOfBirth()));
        employee.setLine1(emp.getAddressLine1());
        employee.setLine2(emp.getAddressLine2());
        employee.setCity(emp.getCity());
        employee.setState(emp.getState());
        employee.setCountry(emp.getCountry());
        employee.setZipCode(emp.getZipCode());
        return employee;
	}
	
	
	/* To validate the date format 
	 * and to check if the date of birth is future date*/
	private Date validateDOB(String dateOfBirth) {
		DateFormat parser = new SimpleDateFormat(GenericConstants.DATE_FORMAT);
		parser.setLenient(false);
		Date date = null;
		
		try {
			date = parser.parse(dateOfBirth);
		} catch (ParseException e) {
			log.error("Expected date is not in the format : yyyy-MM-dd");
			throw new BadRequestException("Employee.date_of_birth : Expected date format is yyyy-MM-dd");
		}
		
		if(new Date().before(date)) {
			
			log.error("Date of birth given is a future date");
			throw new BadRequestException("Employee.date_of_birth : Date Of birth can not be a future Date");
		}
		return date;
	}

	
	

}
