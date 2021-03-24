package com.paypal.bfs.test.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query("Select e from Employee e where e.firstName = :#{#emp.firstName} and e.lastName = :#{#emp.lastName}")
	List<Employee> findByFirstName(@Param ("emp") com.paypal.bfs.test.employeeserv.api.model.Employee emp);

}
