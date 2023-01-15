package com.gl.employeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	//display all employees
	@GetMapping("/")
	public String getAllEmployees(Model model) {
		List<Employee> employees = service.getAllEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}
	
	//CREATE a new employee
	@GetMapping("/new")
	public String createNewEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/";	
	}
	
	@GetMapping("/edit/{id}")
	public String employeeUpdatePage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employee", service.getEmployeeById(id));
		return "update";

	}

	@RequestMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		service.updateEmployee(employee);
		return "redirect:/";
	}
	

	//DELETE an employee
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Long id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/";
	}

}
