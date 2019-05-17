package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;



@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@Autowired
	private Environment env;
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		System.out.println("===========>"+env.getProperty("app.title"));
		return empService.getAllEmployees();
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody Employee emp) {
		return empService.addEmployee(emp);
	}	

	@RequestMapping(value = "/employee/{empid}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("empid") String empid) {
		return empService.getEmployee(empid);
	}

	@RequestMapping(value = "/employee/{empid}", method = RequestMethod.DELETE)
	public Employee deleteEmployee(@PathVariable("empid") String empid) {
		return empService.deleteEmployee(empid);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public Employee modifyEmployee(@RequestBody Employee emp) {
		return empService.modifyEmployee(emp);
	}

}
