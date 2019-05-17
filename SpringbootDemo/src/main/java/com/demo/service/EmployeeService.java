package com.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.demo.model.Employee;

@Service
public class EmployeeService {
	Map<String, Employee> empMap = new HashMap<>();

	public EmployeeService() {
		empMap.put("1234", new Employee("emp1", "1234", "dept1"));
		empMap.put("1235", new Employee("emp2", "1235", "dept2"));
		empMap.put("1236", new Employee("emp3", "1236", "dept3"));
	}

	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(empMap.values());
	}

	public boolean addEmployee(Employee emp) {
		empMap.put(emp.getEmpID(), emp);
		return true;

	}

	public Employee getEmployee(String empid) {
		return empMap.get(empid);
	}

	public Employee deleteEmployee(String empid) {
		return empMap.remove(empid);
	}

	public Employee modifyEmployee(Employee emp) {
		return empMap.put(emp.getEmpID(), emp);

	}
}
