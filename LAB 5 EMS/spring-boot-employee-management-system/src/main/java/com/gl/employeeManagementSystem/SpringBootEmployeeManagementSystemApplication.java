package com.gl.employeeManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.employeeManagementSystem.service.EmployeeService;

@SpringBootApplication
public class SpringBootEmployeeManagementSystemApplication implements CommandLineRunner{

	@Autowired
	EmployeeService serviceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeManagementSystemApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
