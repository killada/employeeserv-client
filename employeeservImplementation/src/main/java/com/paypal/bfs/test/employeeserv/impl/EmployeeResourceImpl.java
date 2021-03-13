package com.paypal.bfs.test.employeeserv.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employee.dao.impl.EmployeeDaoImpl;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	EmployeeDaoImpl employeeDaoImpl;
	
	private static Logger log = LogManager.getLogger(EmployeeResourceImpl.class);
	
	
    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
    	
    	log.info("Get request received for id : "+id);
        Employee employee = employeeDaoImpl.getEmployee(Integer.valueOf(id));

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		
		log.info("Create request received : "+employee.toString());
		Employee emp = employeeDaoImpl.saveEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
		
	}
	
	
}
