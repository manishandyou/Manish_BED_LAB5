package com.gl.employeeManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.repository.EmployeeRepository;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired	
	private EmployeeRepository employeerepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeerepository) {
		this.employeerepository = employeerepository;
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeerepository.findAll();
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeerepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeerepository.findById(id).get() ;
	}

	
	@Override
	public Employee updateEmployee(Employee employee) {
		
		Optional<Employee> result = employeerepository.findById(employee.getId());
		Employee existing= result.get();
		existing.setFname(employee.getFname());
		existing.setLname(employee.getLname());
		existing.setEmail(employee.getEmail());
		
		return employeerepository.save(existing);
		
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeerepository.deleteById(id);
		
	}

}
