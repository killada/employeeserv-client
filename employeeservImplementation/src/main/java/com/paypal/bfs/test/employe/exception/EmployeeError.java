
package com.paypal.bfs.test.employe.exception;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmployeeError {

	private Timestamp timestamp;
	private int status;
	private String error;
	private String message;

}
