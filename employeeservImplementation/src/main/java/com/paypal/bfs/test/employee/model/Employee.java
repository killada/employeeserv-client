package com.paypal.bfs.test.employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	

	public Employee() {
		
	}
	
	public Employee(int employeeId, String firstName, String lastName, Date dateOfBirth, String addressLine1,
			String addressLine2, String city, String state, String country, String zipCode) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}



	@Id @GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "DATE_OF_BIRTH")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Column(name = "ADDRESSLINE1")
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	@Column(name = "ADDRESSLINE2")
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	@Column(name = "CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "ZIP_CODE")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
