package com.paypal.bfs.test.employeeserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.paypal"})
@EnableJpaRepositories("com.paypal.bfs.test.employee.repository")
@EntityScan("com.paypal.bfs.test.employee.model")
public class EmployeeservApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeservApplication.class, args);
    }
}